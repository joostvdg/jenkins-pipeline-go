@Library('github.com/joostvdg/jenkins-pipeline-lib')
import com.github.joostvdg.Utilities

def goHome = tool name: 'Go Latest', type: 'org.jenkinsci.plugins.golang.GolangInstallation'
env.PATH = "${goHome}/bin:${env.PATH}"
env.GOROOT = "${goHome}"

def call() {

    stage('SCM') {
        checkout scm
    }
    stage('Build') {
        sh 'go build src/main.go'
    }
    stage('Run') {
        sh 'go run src/main.go'
    }

    stage('LibExample') {
        def utils = new Utilities(steps)
        String name = 'Joost'
        utils.sayHello(name)
    }
}