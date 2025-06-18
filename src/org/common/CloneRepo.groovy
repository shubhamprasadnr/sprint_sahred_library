package org.common

class CloneRepo implements Serializable {
    def steps
    CloneRepo(steps) { this.steps = steps }

    def call(String repoUrl, String branchName, String credentialsId) {
        steps.echo "Cloning repo: ${repoUrl}, branch: ${branchName}"
        steps.git branch: branchName, credentialsId: credentialsId, url: repoUrl
    }
}
