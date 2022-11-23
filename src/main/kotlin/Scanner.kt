import kotlin.math.pow


data class Scanner(private val input: String) {

    private var current = 0

    val tokenList: ArrayList<Token> = ArrayList()

    fun parse() {
        var peekChar: Char?

        do {
            if (isEOF()) {
                break;
            }

            peekChar = peek();

            when (peekChar) {
                ' ', '\n', '\t', '\r' -> current++
                '+', '-', '*', '/', '(', ')' -> {
                    addToken(TokenType.token_type_from_char(peekChar))
                    current++
                }

                else -> {
                    if (peekChar.isDigit()) {
                        var index = 0;
                        var number = 0.0;

                        while (peekChar?.isDigit() == true) {
                            val tmp = peekChar.code - '0'.code
                            number = number * 10 + tmp
                            index++

                            // next
                            peekChar = next()
                        }


                        if (peekChar == '.') {
                            index = -1

                            // next
                            peekChar = next()

                            while (peekChar?.isDigit() == true) {
                                val tmp = peekChar.code - '0'.code
                                number += 10.0.pow(index.toDouble()) * tmp
                                index--

                                // next
                                peekChar = next()
                            }
                        }

                        addToken(TokenType.Number, number)
                    } else {
                        throw RuntimeException("Invalid character '$peekChar' at index '$current'")
                    }
                }

            }

        } while (true);


    }

    private fun isEOF() = current == input.length

    private fun peek() = input[current]

    private fun next() : Char? = if (++current == input.length) null else peek()

    private fun addToken(type: TokenType, value: Double = 0.0) {
        tokenList.add(Token(type, value))
    }
}

