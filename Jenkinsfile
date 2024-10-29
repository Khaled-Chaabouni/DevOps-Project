pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Your build command here
                    sh 'mvn clean package'
                    
                    // Report success metric to Prometheus
                    sh '''
                    curl -X POST http://192.168.1.13:9090/metrics/job/jenkins_build -d 'build_status=success'
                    '''
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // Your test command here
                    sh 'mvn test'

                    // Report success metric to Prometheus
                    sh '''
                    curl -X POST http://192.168.1.13:9090/metrics/job/jenkins_test -d 'test_status=success'
                    '''
                }
            }
        }
    }
    post {
        always {
            // Clean up or notify Prometheus if necessary
            script {
                sh '''
                curl -X POST http://192.168.1.13:9090/metrics/job/jenkins_build -d 'build_status=completed'
                '''
            }
        }
    }
}
