def checkout = { String subFolder -> 
     checkout([
        $class      : "GitSCM",
        branches    : [[name: "*/systemTests"]],
        extensions  : [[ $class: "RelativeTargetDirectory",
                        relativeTargetDir: subFolder
                       ]],
        userRemoteConfigs: [[
                url : 'git@github.com:josewolff/TestNG-Classes.git',
                credentialsId: "Repository_access"
        ]]
    ])
}    

def runner = { commandToExecute -> isUnix() ? sh(commandToExecute) : bat(commandToExecute) }

parallel Chrome: {
    stage("No Pom - Chrome"){
        node('node-master'){
            checkout("chrome")
            runner 'cd chrome && mvn test -DtestType=system -Dbrowser=chrome -Denv=prod -DgroupsToRun=noPom'
        }
    }    
},
Firefox: {
    stage("No Pom - Firefox"){
        node('node-master'){
            checkout("firefox")
            runner 'cd firefox && mvn test -DtestType=system -Dbrowser=firefox -Denv=prod -DgroupsToRun=noPom'
        }
    }    
},
IE: {
    stage("noPom - IE"){
        node('node-master'){
            checkout("ie")
            runner 'cd ie && mvn test -DtestType=system -Dbrowser=firefox -Denv=prod -DgroupsToRun=noPom'
        }
    }    
}            