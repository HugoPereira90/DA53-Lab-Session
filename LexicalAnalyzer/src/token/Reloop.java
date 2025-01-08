package token;

/**
 * The Reloop token.
 */
public class Reloop extends Token {

    /**
     * Instantiates a new Reloop.
     *
     * @param lexeme the lexeme
     */
    public Reloop(String lexeme) {
        super(lexeme);
    }

    /**
     * Get the token type.
     *
     * @return the token type
     */
    @Override
    public String getTokenType() {
        return "RELOOP";
    }
}
