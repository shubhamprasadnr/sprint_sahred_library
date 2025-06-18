package org.common

class SonarScanner implements Serializable {
    def steps
    SonarScanner(steps) { this.steps = steps }

    def call(String sonarKey, String sonarUrl, String sonarToken) {
        steps.echo "Running SonarQube analysis..."
        steps.withSonarQubeEnv('soanr') {
            steps.sh """
                sonar-scanner \
                    -Dsonar.projectKey=${sonarKey} \
                    -Dsonar.sources=. \
                    -Dsonar.host.url=${sonarUrl} \
                    -Dsonar.login=${sonarToken}
            """
        }
    }
}
