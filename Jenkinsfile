pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
           		tool 'Maven'
                bat 'mvn clean install'
            }
        }
    }
}
