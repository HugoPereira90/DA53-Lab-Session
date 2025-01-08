package token;

/**
 * The type Operator.
 */
public class Operator extends Token{

    /**
     * Instantiates a new Operator.
     *
     * @param lexeme the lexeme
     */
    public Operator(String lexeme) {
        super(lexeme);
    }

    /**
     * Get the token type.
     *
     * @return the token type
     */
    @Override
    public String getTokenType() {
        return "OP";
    }
}
