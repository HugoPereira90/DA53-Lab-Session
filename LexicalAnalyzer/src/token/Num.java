package token;

/**
 * The Num class is a subclass of Token and represents a number token.
 */
public class Num extends Token {

    float value;

    /**
     * Constructor for the Num class.
     *
     * @param lexeme the lexeme
     * @param value  the value of the number
     */
    public Num(String lexeme, float value) {
        super(lexeme);
        this.value = value;
    }

    /**
     * Get the value of the number.
     *
     * @return the value of the number
     */
    public float getValue() {
        return value;
    }

    /**
     * Get the token type.
     *
     * @return the token type
     */
    @Override
    public String getTokenType() {
        return "NUM";
    }
}