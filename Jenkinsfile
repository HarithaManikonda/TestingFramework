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
                sh 'mvn clean install -Dmaven.test.skip=true' 
            }
        }
        stage('Testing and generating testng reports'){
            steps{
                sh 'mvn test'
                step([$class: 'Publisher', reportFilenamePattern: "${workspace}/target/surefire-reports/testng-results.xml"])
            }
        }
        stage('JaCoCo') {
            steps {
                echo 'Code Coverage with JaCoCo'
                sh 'mvn jacoco:report'
            }
        }
         
        stage('Sonar scan') {
            steps {
                sh 'mvn sonar:sonar' 
            }
        }
        
        stage('Deploy - deploy the artifacts to nexus repository') {
            steps {
                sh 'mvn deploy' 
            }
        }
    }
    
    
}
