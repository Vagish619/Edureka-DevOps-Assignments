pipeline {
    agent any
	tools {
        maven 'maven3'
    }
    stages {
        stage('Compile') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('Code Review') {
            steps {
				// Run SonarQube analysis
					//withSonarQubeEnv('SonarQube Server') {
					//sh 'mvn sonar:sonar'
				//}
				echo 'Code Reviewing....'
			}
        }
		
       stage('Unit Test') {
			steps {
				// Run JUnit tests
				sh 'mvn test'
				
				// Generate Cobertura code coverage report
				sh 'mvn cobertura:cobertura'
				
				// Archive Cobertura reports
				cobertura coberturaReportFile: 'target/site/cobertura/coverage.xml',
						autoUpdateHealth: true,
						autoUpdateStability: true,
						failUnhealthy: false,
						failUnstable: false
			}
		}
		
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('Deploy') {
            steps {
                // Add deployment steps here
                // For example, you can use a tool like Tomcat to deploy your WAR file
				echo 'deploying...'
				sh 'mvn tomcat7:deploy'
            }
        }
    }
}