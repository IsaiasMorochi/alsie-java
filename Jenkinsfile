pipeline {
    agent none
    stages {
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.6.3-jdk-11'
                }
            }
            steps {
                sh 'mvn clean package -DskipTests -ntp -B'
            }
        }
        stage('Test') {
            agent {
                docker {
                    image 'maven:3.6.3-jdk-11'
                }
            }
            steps {
                sh 'mvn test'
            }
        }
    }
}
