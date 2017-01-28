package com.github.joostvdg.jenkins.pipeline.common

import java.io.Serializable

class Example implements Serializable {
    def steps

    Example(steps) {this.steps = steps}

    def sayHello(String name) {
        steps.sh "echo $name"
    }
}
