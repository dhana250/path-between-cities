pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
            echo 'jshdfjkshfjkshf...'
                withMaven(maven : 'maven_3_6_3') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
            echo 'rtyrtytdfyrtrt...'
                withMaven(maven : 'maven_3_6_3') {
                    sh 'mvn test'
                }
            }
        }


        stage ('Deployment Stage') {

            steps {
            echo '4564645645645...'
                withMaven(maven : 'maven_3_6_3') {
                    sh 'mvn deploy'
                }
            }
        }
    }
}