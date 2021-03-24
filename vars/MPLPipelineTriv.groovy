def call(body){
	MPLInit()
	def MPL = MPLPipelineConfig(body, [
    agent_label: '',
    modules: [
      Echo: [:],
      Test: [:]
      ]
    ])

	pipeline{
		agent {
			label MPL.agentLabel
		}
		stages{
		  stage('Echo'){
		  	when { expression { MPLModuleEnabled() } }
		  	steps {
		  		MPLModule()
		  	}
		  }
      stage('Test'){
        when { expression { MPLModuleEnabled() } }
        steps {
          MPLModule()
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