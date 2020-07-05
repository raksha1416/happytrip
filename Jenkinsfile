pipeline {
	agent any
	stages {
		stage('Build') { 
			tools {
				jdk 'jdk-11.0.7'
				maven 'apache-maven-3.6.3'
			}
			steps {
				powershell 'java -version'
				powershell 'mvn -version'
			}
		}
		
		
	}
}
