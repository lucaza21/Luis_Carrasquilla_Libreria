def call(Map config = [:]) {
    echo "${config.valor}"
    echo "${config.branch}"
    if ("${config.valor}" == true && "${config.branch}" == null){
        echo "Failing the pipeline due to boolean value: ${config.valor}"
        currentBuild.result = 'FAILURE'
        error("Quality Gate failed. Pipeline stopped.")
    } else if ("${config.branch}" == 'master' || "${config.branch}".startsWith('hotfix')) {
        echo "Failing the pipeline due to branch name: ${config.branch}"
        currentBuild.result = 'FAILURE'
        error("Quality Gate failed. Pipeline stopped.")
    }
     else {
        echo "Not failing the pipeline for branch: ${config.branch}"
    }  
}

