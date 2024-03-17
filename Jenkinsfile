pipeline {
    agent any
	tools {
        maven 'MAVEN3' 
    }
    environment {
        DOCKER_IMAGE = 'wingchijoe/wingchi_lab3'
        DOCKER_TAG = '3.0'
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
    stage('Build & Test with JaCoCo') {
            steps {
                script {
       
                    bat 'mvn clean verify jacoco:report'
                }
            }
        }
        
        stage('Publish JaCoCo Report') {
            steps {
                jacoco execPattern: '**/target/jacoco.exec', classPattern: '**/classes', sourcePattern: '**/src/main/java'
            }
        }
        stage('Docker Build') {
            steps {
                bat "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
            }
        }

	    stage('Docker Login') {  
            steps {
               bat "docker login -u wingchijoe -p ${DOCKER_CREDENTIALS_ID}"
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
