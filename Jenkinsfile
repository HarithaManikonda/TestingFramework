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
        }
        stage('Publish Testng reports'){
         echo "publish report"
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
