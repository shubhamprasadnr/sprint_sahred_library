package org.common

class SonarScanner implements Serializable {
    def steps

    SonarScanner(steps) {
        this.steps = steps
    }

    def call(String sonarKey, String sonarUrl, String credentialId) {
        steps.echo "Running SonarQube analysis..."

        steps.withSonarQubeEnv('sonar') {
            steps.withCredentials([steps.string(credentialsId: credentialId, variable: 'SONAR_TOKEN')]) {
                steps.sh """
                    sonar-scanner \\
                      -Dsonar.projectKey=${sonarKey} \\
                      -Dsonar.sources=. \\
                      -Dsonar.host.url=${sonarUrl} \\
                      -Dsonar.login=$SONAR_TOKEN
                """
            }
        }
    }
}
