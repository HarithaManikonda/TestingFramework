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
             steps{
         echo "publish report"
                 step([$class: 'Publisher', reportFilenamePattern: "${workspace}/(path)/testng-results-mod.xml"])
             }
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
