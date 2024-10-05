pipeline {
    agent any
    tools {
        maven 'Maven'  // Make sure Maven is installed and configured in Jenkins
    }
    stages {
        stage('Git') {
            steps {
                // Checkout the Git repo
                git url: 'https://github.com/Khaled-Chaabouni/SpringAOP.git', branch: 'main'
            }
        }
        stage('Maven Build') {
            steps {
                // Build the project using Maven
                sh 'mvn clean install'
            }
        }
        stage('Maven Test') {
            steps {
                // Run tests using Maven
                sh 'mvn test'
            }
        }
    }
    post {
        always {
            // Archive results even if build fails
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            junit '**/target/surefire-reports/*.xml'
        }
    }
    options {
        timestamps()  // To show time details
    }
}
