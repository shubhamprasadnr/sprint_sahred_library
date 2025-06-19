package org.common

class SonarScanner implements Serializable {
    def steps
    SonarScanner(steps) { this.steps = steps }

   def call(String sonarKey, String sonarUrl, String credentialId) {
    steps.echo "Running SonarQube analysis..."
    
    // Use Jenkins credentials to get the actual token securely
    steps.withCredentials([steps.string(credentialsId: src-sonar, variable: 'SONAR_TOKEN')]) {
        steps.withSonarQubeEnv('sonar') {
            steps.sh """
                sonar-scanner \
                    -Dsonar.projectKey=${sonarKey} \
                    -Dsonar.sources=. \
                    -Dsonar.host.url=${sonarUrl} \
                    -Dsonar.login=${SONAR_TOKEN}
            """
        }
    }
}

