def call(String branchesToAnalyze) {
    if (gitBranch == 'master' || gitBranch.startsWith('hotfix')) {
        echo "Failing the pipeline due to branch name: $gitBranch"
        currentBuild.result = 'FAILURE'
        error("Quality Gate failed. Pipeline stopped.")
    } else {
        echo "Not failing the pipeline for branch: $gitBranch"
    }  
}

