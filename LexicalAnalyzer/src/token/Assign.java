package token;

/**
 * The assign token.
 */
public class Assign extends Token {

    /**
     * Constructor a new assign.
     *
     * @param lexeme the lexeme
     */
    public Assign(String lexeme) {
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
