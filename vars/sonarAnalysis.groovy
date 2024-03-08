def call(List<String> branchesToAnalyze = ['develop']) {
    def shouldFailAlways = System.getenv("FAIL_ALWAYS") ?: false

    def shouldFailBasedOnBranch = !shouldFailAlways

    branchesToAnalyze.each { gitBranch ->
        if (shouldFailBasedOnBranch) {
            if (shouldFailAlways || gitBranch == 'master' || gitBranch.startsWith('hotfix')) {
                echo "Failing the pipeline due to branch name: $gitBranch"
                currentBuild.result = 'FAILURE'
                error("Quality Gate failed. Pipeline stopped.")
            } else {
                echo "Not failing the pipeline for branch: $gitBranch"
            }
        } else {
            echo "Failing the pipeline as per configuration"
            currentBuild.result = 'FAILURE'
            error("Quality Gate failed. Pipeline stopped.")
        }
    }
}

