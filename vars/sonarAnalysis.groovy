def call(Boolean valor) {
    timeout(time:5, unit:'MINUTES'){
        sh 'echo Iniciando las quality gates'
        sh "sleep 10"
        waitForQualityGate abortPipeline:${valor}
    }
}