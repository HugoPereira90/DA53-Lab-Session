package token;

public class Keyword extends Token {

    public Keyword(String lexeme) {
        super(lexeme);
    }

    /**
     * Get the token type.
     *
     * @return the token type
     */
    @Override
    public String getTokenType() {
        return "";
    }
}