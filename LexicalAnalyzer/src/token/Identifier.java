package token;

public class Identifier extends Token {

    public Identifier(String lexeme) {
        super(lexeme);
    }

    /**
     * Get the token type.
     *
     * @return the token type
     */
    @Override
    public String getTokenType() {
        return "ID";
    }
}
