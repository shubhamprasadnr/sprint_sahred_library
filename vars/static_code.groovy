def call(String sonarProjectKey) {
  def sonarprojectkey = 'java'
    withSonarQubeEnv('sonarqube') {
        withCredentials([string(credentialsId: 'sonarcred', variable: 'SONARQUBE_TOKEN')]) {
            sh """
            mvn sonar:sonar \
                -Dsonar.projectKey=${sonarProjectKey} \
                -Dsonar.login=${SONARQUBE_TOKEN}
            """
        }
    }
}
