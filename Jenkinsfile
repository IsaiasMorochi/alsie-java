pipeline {
//     agent {
//         label "docker-build-node"
//     }
    agent any
    tools {
        maven 'maven-3.8.6'
    }

    environment {
        DOCKERHUB_CREDENTIALS = 'dockerhub-credentials'
        GITHUB_CREDENTIAL_ID = 'github-credentials'
        KUBECONFIG_CREDENTIAL_ID = ''
        REGISTRY = 'docker.io'
        DOCKERHUB_NAMESPACE = 'isaiasdocker'
        GITHUB_ACCOUNT = ''
        APP_NAME = 'alsie-java'
        BRANCH_NAME = 'main'
        URL_REPOSITORY = 'https://github.com/IsaiasMorochi/alsie-java.git'
    }

    stages {

        stage('Checkout scm') {
            steps {
                git branch: "$BRANCH_NAME",
                credentialsId: "$GITHUB_CREDENTIAL_ID",
                url: "$URL_REPOSITORY"
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests -B -ntp'
            }
            post {
                always {
                    echo 'siempre se ejecuta el build'
                }
                success {
                    echo 'cuando es exitoso el build'
                }
                failure {
                    echo 'cuando falla el build'
                }
            }
        }

        stage('Unit Test') {
            steps {
                sh 'mvn test -B -ntp'
            }
            post {
                always {
                    echo 'siempre se ejecutan los test'
                }
                success {
                    echo 'cuando es exitoso los test'
                    //jacoco()
                    //junit 'target/surefire-reports/*.xml'
                }
                failure {
                    echo 'cuando fallan los test'
                }
            }
        }

        stage ('Build & Push Dockerhub') {
            steps {
                sh 'docker build -f Dockerfile -t $REGISTRY/$DOCKERHUB_NAMESPACE/$APP_NAME:$BRANCH_NAME-$BUILD_NUMBER .'
                withCredentials([usernamePassword(passwordVariable : 'DOCKER_PASSWORD' ,usernameVariable : 'DOCKER_USERNAME' , credentialsId : "$DOCKERHUB_CREDENTIALS",)]) {
                    sh 'echo "$DOCKER_PASSWORD" | docker login $REGISTRY -u "$DOCKER_USERNAME" --password-stdin'
                    sh 'docker push $REGISTRY/$DOCKERHUB_NAMESPACE/$APP_NAME:$BRANCH_NAME-$BUILD_NUMBER'
                }
            }
        }

   }

   post {
       success {
           archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
           deleteDir()
       }
       always {
          sh 'docker logout'
       }
   }
}
