pipeline {
    agent any
    tools {
        maven 'MAVEN3' 
    }
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
    }
}
