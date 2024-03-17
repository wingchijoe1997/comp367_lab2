pipeline {
    agent any
	tools {
        maven 'MAVEN3' 
    }
    environment {
        DOCKER_IMAGE = 'wingchijoe/wingchi_lab3'
        DOCKER_TAG = '2.0'
        DOCKER_CREDENTIALS_ID = credentials('WingChiDockerHubToken')
    }

    stages {
        stage('Check out') {n
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

        stage('Docker Login') {
            steps {
                withCredentials([usernamePassword(credentialsId: DOCKER_CREDENTIALS_ID, usernameVariable: 'DOCKER_HUB_USERNAME', passwordVariable: 'DOCKER_HUB_PASSWORD')]) {
                    bat "echo %DOCKER_HUB_PASSWORD% | docker login -u %DOCKER_HUB_USERNAME% --password-stdin"
                }
            }
        }

        stage('Docker Push') {
            steps {
                bat "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
            }
        }
    }

    post {
        always {
            bat "docker rmi ${DOCKER_IMAGE}:${DOCKER_TAG}"
        }
    }
}
