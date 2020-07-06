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
                bat "mvn clean compile" 
	     
            }
            }
      
      stage ('Test Stage') {
            steps {
               
	       
            bat "mvn test"
            }
      }
   }
}
