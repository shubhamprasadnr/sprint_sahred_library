package org.common

class MavenBuilder implements Serializable {
    def steps
    MavenBuilder(steps) {
        this.steps = steps
    }

    def buildProject() {
        steps.echo "Building project with Maven (skipping tests)..."
        steps.sh "mvn clean package -DskipTests"
    }
}
