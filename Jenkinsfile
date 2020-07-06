pipeline {
   agent any
   stages {
       stage('Git-Checkout') {
         steps {
            echo 'Checking out from Gitlab Repo'
            git 'https://github.com/raksha1416/happytrip.git'
         }
      }
      stage ('Build Stage') {
            steps {
                withMaven(maven : 'Maven-3.6.3') {
	        bat script: 'mvn compile'
            }
            }
      }
      stage ('Test Stage') {
            steps {
                withMaven(maven : 'Maven-3.6.3') {
	        bat script: 'mvn test -Dbrowser=chrome' 
            }
            }
      }
   }
}
