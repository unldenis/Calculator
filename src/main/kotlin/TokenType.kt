enum class TokenType {
    Number,
    Plus,
    Minus,
    Cross,
    Division,

    LParen,
    RParen
    ;


    companion object {

        @JvmStatic
        fun tokenTypeFromChar(t: Char): TokenType =
            when (t) {
                '+' -> Plus
                '-' -> Minus
                '*' -> Cross
                '/' -> Division
                '(' -> LParen
                ')' -> RParen
                else -> {
                    throw RuntimeException("Operator not available for the character $t");
                }
            }
    }

}

