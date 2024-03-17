pipeline {
    agent any
	tools {
        maven 'MAVEN3' 
    }
    environment {
        DOCKER_IMAGE = 'wingchijoe/wingchi_lab3'
        DOCKER_TAG = '2.0'
        DOCKER_CREDENTIALS_ID = credentials('DockerHubToken')
    }

    stages {
        stage('Check out') {
            steps {
                git url: 'https://github.com/wingchijoe1997/comp367_lab2.git', branch: 'main'
            }
        }

        stage('Build Maven project') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Code coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }

        stage('Docker Build') {
            steps {
                bat "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
            }
        }

	    stage('Docker Push') {
            steps {
                script {
                    docker.withRegistry('', 'DockerHubToken') {
                        docker.image('wingchijoe/wingchi_lab3:2.0').push()
                    }
                }
            }
        }
    }

    post {
        always {
            bat "docker rmi ${DOCKER_IMAGE}:${DOCKER_TAG}"
        }
    }
}
