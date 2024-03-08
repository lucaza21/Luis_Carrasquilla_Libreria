def call(boolean valor) {
    timeout(time:5, unit:'MINUTES'){
        sh 'echo Iniciando las quality gates'
        sh "echo el parametro enviado es: ${valor}"
        waitForQualityGate abortPipeline: "${valor}"
    }
}
