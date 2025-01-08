package token;

public class Coma extends Token{

    /**
     * Instantiates a new Coma.
     *
     * @param lexeme the lexeme
     */
    public Coma(String lexeme) {
        super(lexeme);
    }

    /**
     * Get the token type.
     *
     * @return the token type
     */
    @Override
    public String getTokenType() {
        return "COMA";
    }
}
