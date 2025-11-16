pipeline {
    agent any

    environment {
        EC2_HOST = "13.201.178.233"
        EC2_USER = "ec2-user"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build JAR') {
            steps {
                sh "./mvnw clean package -DskipTests"
            }
        }

        stage('Copy JAR to EC2') {
            steps {
                sshagent(['ec2-ssh-key']) {
                    sh """
                        scp -o StrictHostKeyChecking=no target/*.jar ${EC2_USER}@${EC2_HOST}:/home/${EC2_USER}/product-api.jar
                    """
                }
            }
        }

        stage('Deploy to EC2') {
            steps {
                sshagent(['ec2-ssh-key']) {
                    sh """
                        ssh -o StrictHostKeyChecking=no ${EC2_USER}@${EC2_HOST} 'bash /opt/product-api/scripts/deploy.sh'
                    """
                }
            }
        }
    }

    post {
        success {
            echo "Deployment successful!"
        }
        failure {
            echo "Deployment failed!"
        }
    }
}
