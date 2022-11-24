data class Token(val type: TokenType, val value: Double) {

    override fun toString(): String =
        if (type == TokenType.Number) "Token {type='Number', value='${value}'}" else "Token {type='${type.name}'}"


}
