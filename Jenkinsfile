pipeline {
    agent any
    tools {
        maven 'MAVEN3' // Use the name of the Maven installation
    }
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
    }
}
