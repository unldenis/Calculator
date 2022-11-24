import java.util.*

fun main() {

    while (true) {
        print("> ")
        val input = readlnOrNull() ?: ""

        if(input.lowercase() == "exit") {
            break
        }

        Scanner(input).run {
            parse()

            val parser = Parser(tokenList)

            try {
                println(parser.parse())
            } catch (e : RuntimeException) {
                println("Error: ${e.message}")
            }

        }



    }

}