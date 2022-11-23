enum class TokenType {
    Number,
    Plus,
    Minus,
    Cross,
    Division,

    L_Paren,
    R_Paren
    ;


    companion object {

        @JvmStatic
        fun token_type_from_char(t: Char): TokenType =
            when (t) {
                '+' -> Plus
                '-' -> Minus
                '*' -> Cross
                '/' -> Division
                '(' -> L_Paren
                ')' -> R_Paren
                else -> {
                    throw RuntimeException("Operator not available for the character $t");
                }
            }
    }

}

