pipeline {
    agent any // Use any available agent

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the Git repository
                git branch: 'main', url: 'https://github.com/Khaled-Chaabouni/DevOps-Project'
            }
        }

        stage('Build') {
            steps {
                // Run the Maven build
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Run the Maven tests
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                // Deploy steps can go here
                echo 'Deploying the application...'
            }
        }
    }

    post {
        always {
            // Archive the test results
            junit '**/target/surefire-reports/*.xml' // Adjust the path as necessary
        }
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
