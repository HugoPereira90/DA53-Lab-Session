package token;

/**
 * The StringContent class is used to represent a string content token.
 */
public class StringContent extends Token {

    /**
     * Construct a StringContent object.
     *
     * @param lexeme the string representation of the token
     */
    public StringContent(String lexeme) {
        super(lexeme);
    }

    /**
     * Get the token type.
     *
     * @return the token type
     */
    @Override
    public String getTokenType() {
        return "STRING";
    }
}
