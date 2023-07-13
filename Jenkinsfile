pipeline {
    agent none

    stages {
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.9.3-eclipse-temurin-11'
                }
            }
            steps {
                echo 'Building..'
                sh 'mvn -B package --file pom.xml'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
