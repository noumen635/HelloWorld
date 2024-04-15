pipeline {
    agent any

    tools {
        maven 'maven-3.9.6'
    }

    stages {
        stage('Code Analysis') {
            steps {
                echo 'Performing code quality checks'
            }
        }

        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Automated Testing') {
            steps {
                echo 'Performing automated testing'
            }
        }

        stage('Build Artifact') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Image') {
            steps {
                sh 'docker build -t noumendarryl/helloworld:1.${BUILD_NUMBER} . '
                sh 'docker build -t noumendarryl/helloworld:latest . '
            }
        }

        stage('Deploy on DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'DOCKER_ID', passwordVariable: 'DOCKER_PWD', usernameVariable: 'DOCKER_USERNAME')]) {
                    sh 'docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PWD}'
                }
                sh 'docker push noumendarryl/helloworld:1.${BUILD_NUMBER}'
                sh 'docker push noumendarryl/helloworld:latest'
            }
        }

        stage('Email Notification') {
            steps {
                emailext body: '$PROJECT_NAME - BUILD # $BUILD_NUMBER - $BUILD_STATUS : Check console output at $BUILD_URL to view results. Please note this is an automated email.',
                subject: '$PROJECT_NAME - BUILD # $BUILD_NUMBER - $BUILD_STATUS',
                to: 'ndrayl70@gmail.com'
            }
        }
    }
}