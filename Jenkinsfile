pipeline{
  agent any
  tools{
  maven 'maven3'
  }
  stages{
  stage('Compile'){
  steps{
  sh 'mvn clean compile'
  } 
  }
  stage('Testing'){
  steps{
  sh 'mvn clean test'
  } 
  }
  stage('Packaging'){
  steps{
  sh 'mvn package'
  } 
  }
  }
   post{
    success{
        junit '**/target/surefire-reports/TEST-*.xml'
        archiveArtifacts 'target/*.jar'
    }
  }
  
}
