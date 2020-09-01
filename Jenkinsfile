pipeline {
  agent any
  stages {
    stage('Build, Test and Quality Gate Analysis') {
      steps {
        withSonarQubeEnv(installationName: 'SonarQube', credentialsId: 'sonarqube') {
          sh 'mvn clean verify sonar:sonar -PintegrationTest'
        }

      }
    }

  }
}