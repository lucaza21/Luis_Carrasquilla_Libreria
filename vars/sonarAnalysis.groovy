def call(Boolean valor, String branch) {
    if (valor == true){
        echo "Failing the pipeline due to boolean value: ${valor}"
        currentBuild.result = 'FAILURE'
        error("Quality Gate failed. Pipeline stopped.")
    } else if ("${branch}" == 'master' || "${branch}".startsWith('hotfix')) {
        echo "Failing the pipeline due to branch name: ${branch}"
        currentBuild.result = 'FAILURE'
        error("Quality Gate failed. Pipeline stopped.")
    }
     else {
        echo "Not failing the pipeline for branch: ${branch}"
    }  
}

