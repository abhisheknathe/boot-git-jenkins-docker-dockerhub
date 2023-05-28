pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/abhisheknathe/boot-git-jenkins-docker-dockerhub']])

                // Run Maven on a Unix agent.
                bat "mvn clean install"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }


        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t abhisheknathe/spring-boot-blank .'
            }
        }

        stage('Push image to Docker Hub'){
            steps {
                script {
                    withCredentials([string(credentialsId: 'docker', variable: 'docker')]) {
                    bat 'docker login -u abhisheknathe -p marigoldseason docker.io'
                    bat 'docker push abhisheknathe/spring-boot-blank:latest'
                    }
                }
            }
        }
    }
}
