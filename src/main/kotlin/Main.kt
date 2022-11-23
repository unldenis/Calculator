fun main() {
    print("> ")
    val input : String? = readlnOrNull()

    val scanner = Scanner(input ?: "")
    scanner.parse()

    println(scanner.tokenList)
}