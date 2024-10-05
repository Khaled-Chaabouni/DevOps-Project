pipeline {
    agent any
    tools {
        maven 'M2_HOME'  // Ensure Maven is installed and configured in Jenkins
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
    }
    post {
        always {
            // Archive results even if the build fails
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        }
    }
    options {
        timestamps()  // To show time details
    }
}
