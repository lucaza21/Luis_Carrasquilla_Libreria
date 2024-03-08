def call(boolean valor) {
    def SonarEnv(){
            sh 'echo Ejecucion de las pruebas de calidad de codigo'
        }
    timeout(time:5, unit:'MINUTES'){
        sh 'echo Iniciando las quality gates'
        sh "sleep 3"
        sh "echo ${valor}"
        waitForQualityGate abortPipeline: "${valor}"
    }
}
