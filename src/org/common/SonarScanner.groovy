package org.common

class SonarScanner implements Serializable {
    def steps

    SonarScanner(steps) {
        this.steps = steps
    }

    def call(String sonarKey, String sonarUrl, String credentialId, String buildTool = "maven") {
        steps.echo "Compiling project..."
        if (buildTool == "maven") {
            steps.sh 'mvn clean compile'
        } else if (buildTool == "gradle") {
            steps.sh './gradlew build'
        }

        steps.echo "Running SonarQube analysis..."

        steps.withSonarQubeEnv('sonar') {
            steps.withCredentials([steps.string(credentialsId: credentialId, variable: 'SONAR_TOKEN')]) {
                def binariesDir = (buildTool == "maven") ? "target/classes" : "build/classes"

                steps.sh """
                    sonar-scanner \\
                      -Dsonar.projectKey=${sonarKey} \\
                      -Dsonar.sources=. \\
                      -Dsonar.host.url=${sonarUrl} \\
                      -Dsonar.login=\$SONAR_TOKEN \\
                      -Dsonar.java.binaries=${binariesDir}
                """
            }
        }
    }
}
