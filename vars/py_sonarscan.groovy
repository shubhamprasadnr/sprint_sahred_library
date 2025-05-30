// vars/static_code.groovy
def call() {
    withSonarQubeEnv('SonarQube') {
        withCredentials([string(credentialsId: 'attendance_cred', variable: 'SONAR_TOKEN')]) {
            def scannerHome = tool 'sonarqube'
            sh """
                ${scannerHome}/bin/sonar-scanner \
                -Dsonar.projectKey=${env.SONAR_PROJECT_KEY} \
                -Dsonar.sources=. \
                -Dsonar.login=$SONAR_TOKEN
            """
        }
    }
}

