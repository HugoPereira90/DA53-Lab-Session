package token;

/**
 * The OpenParentesis class is used to represent an open parentesis token.
 */
public class OpenParentesis extends Token {

    /**
     * Construct an OpenParentesis object.
     *
     * @param lexeme the string representation of the token
     */
    public OpenParentesis(String lexeme) {
        super(lexeme);
    }

    /**
     * Get the token type.
     *
     * @return the token type
     */
    @Override
    public String getTokenType() {
        return "OPEN_PARENTESIS";
    }
}

