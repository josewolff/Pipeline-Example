
def runner = { commandToExecute -> isUnix() ? sh(commandToExecute) : bat(commandToExecute) }

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