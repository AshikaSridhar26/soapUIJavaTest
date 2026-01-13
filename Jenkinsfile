pipeline {
    agent any // Tells Jenkins to use any available agent/machine

    stages {
        stage('Checkout Code') {
            // Jenkins automatically checks out the SCM repo before running the pipeline
            steps {
                echo 'Code checked out successfully.'
            }
        }
        stage('Run Tests via Docker Compose') {
            steps {
                sh 'docker compose run --rm tests'
            }
        }
    }
    post {
        always {
            echo 'Pipeline finished.'
            // Add steps here to publish test results, clean up, etc.
        }
    }
}
