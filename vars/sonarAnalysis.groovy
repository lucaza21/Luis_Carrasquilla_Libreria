def call(boolean valor) {
    timeout(time:5, unit:'MINUTES'){
        sh 'echo Iniciando las quality gates'
        sh "sleep 10"
        sh "echo ${valor}"
        waitForQualityGate abortPipeline:"${valor}"
    }
}
