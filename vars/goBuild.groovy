import com.github.joostvdg.Utilities

def call() {

    stage('LibExample') {
        def utils = new Utilities(steps)
        String name = 'Joost'
        utils.sayHello(name)
    }


    stage('SCM') {
        checkout scm
    }

    dir('src'){

        docker.image('golang').inside {
            stage('Build') {
                sh 'go get -d -v -t && go build -v -o hello-world-go'
            }
        }
        stage('Run') {
            sh 'go run src/main.go'
        }
        stage('Archive') {
            archive 'hello-world-go'
        }
    }


}