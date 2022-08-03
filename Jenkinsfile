pipeline{
    agent {
        label 'my-jenkins-slave'
    }
    tools{
        maven 'Maven3'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/demo-jenkins']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/KSukhjinder/jenkins-practic']]])
                sh 'mvn clean install'

            }
        }
        stage('Build docker image'){
            steps{
                script{
                    // sh 'docker login -u=reactivestaxtechsukhjinder -p=docker123'
                    sh 'docker build -t reactivestaxtechsukhjinder/devops-integration -f Dockerfile .'
                    // sh 'docker images'
                    // sh 'docker push reactivestaxtechsukhjinder/devops-integration'
                    // sh 'docker rmi reactivestaxtechsukhjinder/devops-integration'
                    // sh 'docker images'
                }
            }
        }
        stage('Push image to hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]){
                    sh 'docker login -u reactivestaxtechsukhjinder -p ${dockerhubpwd}'
                    }
                }
                sh 'docker push reactivestaxtechsukhjinder/devops-integration'
            }
        }
        stage('Deploy to k8s'){
            steps{
                script{
                    kubernetesDeploy (configs: 'deploymentservice.yaml', kubeconfigId: 'k8sconfigpwd')
                }
            }
        }
    }
}