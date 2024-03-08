def call(String name, String day) {
    sh 'echo "Ejecución de las pruebas de calidad de código"'
    sh "echo Hola ${name}. Hoy es  ${day}"
}