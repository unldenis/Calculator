class Parser(val list: List<Token>) {

    var index = 0;


    private fun current() = list[index]

    private fun eat(): Token {
        val t = current()
        index++
        return t
    }

    private fun parsePrimary(): Double {
        if (current().type === TokenType.LParen) {
            //LParen
            eat()
            val paren = parseTerm()
            if (current().type !== TokenType.RParen) {
                throw RuntimeException("Closing parenthesis expected at '${index - 1}' index but found '${current().type}'.")
            }

            //RParen
            eat()
            return paren
        }
        val t = eat()
        if (t.type !== TokenType.Number) {
            throw RuntimeException("Number expected at '${index - 1}' index but found '${t.type}'.")
        }
        return t.value;
    }

    private fun parseUnary(): Double {
        if (current().type === TokenType.Minus) {
            // Minus
            eat()
            val right = parsePrimary()
            return -right
        }
        return parsePrimary()
    }

    private fun parseFactor(): Double {
        var left = parseUnary()

        while (index < list.size && (current().type === TokenType.Cross || current().type === TokenType.Division)) {
            val operator = eat().type
            val right = parseUnary()
//            if(operator === TokenType.Cross) {
//                left *= right
//            } else {
//                left /= right
//            }
            left *= if (operator === TokenType.Cross) right else 1 / right
        }
        return left;
    }

    private fun parseTerm(): Double {
        var left = parseFactor()

        while (index < list.size && (current().type === TokenType.Plus || current().type === TokenType.Minus)) {
            val operator = eat().type
            val right = parseFactor()
            left += if (operator === TokenType.Plus) right else -right
        }
        return left;
    }


    fun parse() = parseTerm()

}