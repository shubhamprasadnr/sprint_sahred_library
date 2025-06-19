package org.common

class MavenBuilder implements Serializable {
    def steps
    MavenBuilder(steps) {
        this.steps = steps
    }

    def buildProject() {
        steps.echo "Building project with Maven..."
        steps.sh "mvn clean package"
    }
}
