def call(boolean valor) {
    stage('Checkout'){
        checkoutCode()
    }
}

def checkoutCode(){
    checkout scm
}
