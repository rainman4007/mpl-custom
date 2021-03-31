def call(body) {
  library('grid-mpl')
  MPLModulesPath('com/triv/devops/mpl')

  def MPL = MPLPipelineConfig(body, [
    agent_label: '',
    modules: [:]
  ])
  
  
  pipeline {
    agent {
      label MPL.agentLabel
    }

    stages {
      stage('Initialize') {
        steps {
          script {
            
            // For each key in MPL.modules produce a stage with that name
            MPL.modules.each { module ->
              print("Initializing with stage ${module}.")
              if ( MPLModuleEnabled(module) ) {
                stage(module) {
                  MPLModule()
                }
              }
            }
          }
        }
      }
    }
    
    post {
      always {
        MPLPostStepsRun('always')
      }

      success {
        MPLPostStepsRun('success')
      }

      failure {
        MPLPostStepsRun('failure')
      }
    }
  }
}
