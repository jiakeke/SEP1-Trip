pipeline {
    agent any
     environment {
            // Define Docker Hub credentials ID
            DOCKERHUB_CREDENTIALS_ID = 'Docket_Hub'
            // Define Docker Hub repository name
            DOCKERHUB_REPO = 'jiakeke/week7_inclass'
            // Define Docker image tag
            DOCKER_IMAGE_TAG = 'latest_v1'
        }
    stages {
        stage('Checkout') {
            steps {
                /* git 'https://github.com/ADirin/SEP1_Week7_Spring2025_Inclass.git' */
                /* git 'https://github.com/jiakeke/SEP1-Trip.git' */
                git branch: 'main', url: 'https://github.com/jiakeke/SEP1-Trip.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Code Coverage') {
            steps {
                sh 'mvn jacoco:report'
            }
        }
        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

         stage('Build Docker Image') {
                    steps {
                        /* // Build Docker image */
                        /* script { */
                            /* docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}") */
                        /* } */

                        script {
                            sh """
                            docker buildx create --name mybuilder --use || true
                            docker buildx inspect mybuilder || true
                            """

                            sh """
                            docker buildx build --platform linux/amd64 --load -t ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG} .
                            """
                        }

                    }

                }
                stage('Push Docker Image to Docker Hub') {
                    steps {
                        // Push Docker image to Docker Hub
                        script {
                            docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                                docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                            }
                        }
                    }
                }
    }
}
