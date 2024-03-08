def call(Map config = [:]) {
    echo "${config.valor}"
    echo "${config.branch}"
    if (${config.valor} == true && ${config.branch} == null){
        echo "Failing the pipeline due to boolean value: ${config.valor}"
        currentBuild.result = 'FAILURE'
        error("Quality Gate failed. Pipeline stopped.")
    }     
}

