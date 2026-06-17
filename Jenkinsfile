pipeline {
    agent any

    tools {
        jdk 'jdk-17'
    }

    environment {
        APP_NAME = 'online-bookstore'
    }

    stages {
        stage('1. Checkout') {
            steps {
                echo '检出代码...'
                checkout scm
            }
        }

        stage('2. Environment Check') {
            steps {
                echo '检查 JDK 版本...'
                bat 'java -version'
                echo '检查 Maven Wrapper...'
                bat 'mvnw.cmd -version'
            }
        }

        stage('3. Compile') {
            steps {
                echo 'Maven 编译...'
                bat 'mvnw.cmd clean compile'
            }
        }

        stage('4. Unit Test') {
            steps {
                echo '运行单元测试...'
                bat 'mvnw.cmd test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('5. Comment Coverage Check') {
            steps {
                echo '检查注释覆盖率（要求 >= 30%）...'
                bat 'python scripts/check_comment_coverage.py src/main/java'
            }
        }

        stage('6. JaCoCo Report') {
            steps {
                echo '生成 JaCoCo 覆盖率报告...'
                bat 'mvnw.cmd jacoco:report'
            }
            post {
                always {
                    publishHTML(target: [
                        allowMissing: true,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/site/jacoco',
                        reportFiles: 'index.html',
                        reportName: 'JaCoCo Coverage'
                    ])
                }
            }
        }

        stage('7. Package') {
            steps {
                echo 'Maven 打包（跳过测试，因已在 Stage 4 运行）...'
                bat 'mvnw.cmd package -DskipTests'
            }
        }

        stage('8. Archive Artifacts') {
            steps {
                echo '归档构建产物...'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                archiveArtifacts artifacts: 'target/site/jacoco/**', fingerprint: false
            }
        }
    }

    post {
        success {
            echo 'Pipeline 执行成功！'
        }
        failure {
            echo 'Pipeline 执行失败，请检查日志。'
        }
    }
}
