pipeline {
    agent any
    tools {
        maven 'Maven3' // Use the name of the Maven installation
    }
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
    }
}
