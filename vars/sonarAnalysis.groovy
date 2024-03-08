def call(String branchesToAnalyze) {
    sh " echo ${branchesToAnalyze} "
    if ("${branchesToAnalyze}" == 'master' || "${branchesToAnalyze}".startsWith('hotfix')) {
        echo "Failing the pipeline due to branch name: $gitBranch"
        currentBuild.result = 'FAILURE'
        error("Quality Gate failed. Pipeline stopped.")
    } else {
        echo "Not failing the pipeline for branch: $gitBranch"
    }  
}

