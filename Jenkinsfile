pipeline{
  agent any
  tools{
  maven 'maven3'
  }
  stages{
  stage('Compile'){
  steps{
  bat 'mvn clean compile'
  } 
  }
  stage('Testing'){
  steps{
  bat 'mvn clean test'
  } 
  }
  stage('Packaging'){
  steps{
  bat 'mvn package'
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
