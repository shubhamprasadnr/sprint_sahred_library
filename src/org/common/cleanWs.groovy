package org.common

class CleanWS implements Serializable {
    def steps
    CleanWS(steps) { this.steps = steps }

    def call() {
        steps.echo "Cleaning workspace..."
        steps.cleanWs()
    }
}
