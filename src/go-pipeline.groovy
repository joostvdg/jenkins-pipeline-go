#!/usr/bin/groovy
// requires shared global library with GIT SCM: https://github.com/joostvdg/jenkins-pipeline-lib
@Library('github.com/joostvdg/jenkins-pipeline-lib@master')
import com.github.joostvdg.Utilities


def goHome = tool name: 'Go Latest', type: 'org.jenkinsci.plugins.golang.GolangInstallation'
env.PATH = "${goHome}/bin:${env.PATH}"
env.GOROOT = "${goHome}"

def checkout() {
    stage('SCM') {
        checkout scm
    }
}

def build() {
    stage('Build') {
        sh 'go build src/main.go'
    }
}

def run () {
    stage('Run') {
        sh 'go run src/main.go'
    }
}


def executeExample() {
    def utils = new Utilities(steps)
    String name = 'Joost'
    utils.sayHello(name)

}