pipeline {
    agent any

    environment {
        STUDENT_NAME = 'Kaisbayev Almas'
        IMAGE_NAME   = 'kaisbayev-almas-student-api'
        IMAGE_TAG    = 'v1.0-kaisbayev-almas'
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Pipeline started by student: ${STUDENT_NAME}"
                checkout scm
                sh 'git log -1 --oneline'
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build -x test --no-daemon'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test --no-daemon'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'build/test-results/test/*.xml'
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
            }
        }

        stage('Verify') {
            steps {
                sh "docker image inspect ${IMAGE_NAME}:${IMAGE_TAG} > /dev/null"
                sh "docker images ${IMAGE_NAME}:${IMAGE_TAG}"
                echo "VERIFY OK: image ${IMAGE_NAME}:${IMAGE_TAG} exists (student: ${STUDENT_NAME})"
            }
        }
    }

    post {
        success { echo "Pipeline SUCCESS for ${STUDENT_NAME}" }
        failure { echo "Pipeline FAILED for ${STUDENT_NAME}" }
    }
}
