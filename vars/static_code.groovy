def call() {
    withSonarQubeEnv('SonarQube') {
        sh """
            mvn clean verify sonar:sonar \
            -Dsonar.projectKey=${env.SONAR_PROJECT_KEY}
        """
    }
}
