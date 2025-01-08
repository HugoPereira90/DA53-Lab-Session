package token;

public class CloseParentesis extends Token {

    public CloseParentesis(String lexeme) {
        super(lexeme);
    }

    /**
     * Get the token type.
     *
     * @return the token type
     */
    @Override
    public String getTokenType() {
        return "CLOSE_PARENTESIS";
    }
}