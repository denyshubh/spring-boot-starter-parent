pipeline {
  agent any
  stages {
    stage('Build, Test and Quality Gate Analysis') {
      parallel {
        stage('Build, Test and Quality Gate Analysis') {
          steps {
            withSonarQubeEnv('SonarQube') {
              sh 'mvn clean verify sonar:sonar -PintegrationTest'
            }

          }
        }

        stage('Print Parallel Build Test') {
          steps {
            echo 'Hi I am a Parallel Job to Build Test and Quality Gate ANalysis'
          }
        }

      }
    }

    stage('SonarQube Quality Gate Check') {
      steps {
        script {
          timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
          def qualitygate = waitForQualityGate()
          if (qualitygate.status != "OK") {
            error "Pipeline aborted due to quality gate coverage failure: ${qualitygate.status}"
          }
        }
      }

    }
  }

}
environment {
  PROJECT_NAME = "${project}"
}
post {
  success {
    script {
      jacoco()
    }

  }

}
}