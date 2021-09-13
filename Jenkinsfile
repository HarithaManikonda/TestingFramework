pipeline {
    agent any
    
    tools {
        maven 'maven'
        jdk 'jdk8'
    }
    

    stages {
    
    stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test'){
            steps{
                sh 'mvn test'
            }
            step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
        }
              
        stage('Sonar scan') {
            steps {
                sh 'mvn sonar:sonar' 
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
    
    
}
