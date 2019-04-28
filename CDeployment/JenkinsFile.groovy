
def runner = { commandToExecute -> isUnix() ? sh(commandToExecute) : bat(commandToExecute) }
def description = ""
def nameWhoApproveOrReject = ""
buils: {
    stage("Build - Stage"){
        node('master'){
            runner 'echo Code to Buils the code'
            sleep 2
        }
    }    
}
unitTests: {
    stage("Unit Tests - Stage"){
        node('master'){
            runner 'echo Code to execute unit tests'
            sleep 2
        }
    }    
}
integrationTests: {
    stage("Integration Tests - Stage"){
        node('master'){
            runner 'echo Code to execute Integration tests'
            sleep 4
        }
    }    
}
systemTests: {
    stage("System Tests - Stage"){
        node('master'){
            runner 'echo Code to execute System tests'
            sleep 7
        }
    }    
}
deployingStaging: {
    stage("Deploying to Staging"){
        node('master'){
            runner 'echo Code to deploy'
            sleep 7
        }
    }    
}
smokeTests: {
    stage("SmokeTests - Integration/System"){
        node('master'){
            runner 'echo Code to execute System tests'
            sleep 7
        }
    }    
}
deployToProd: {
    stage("Deploying to Production"){
        node('master'){
            runner 'echo Code to execute deploy'
            sleep 7
        }
    }    
}

