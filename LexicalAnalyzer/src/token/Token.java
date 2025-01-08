package token;

/**
 * Abstract class to represent a token.
 */
public abstract class Token implements Comparable<Token> {
    private String lexeme;

    // Constructor
    public Token(String lexeme) {
        this.lexeme = lexeme;
    }

    /**
     * Get the token type.
     *
     * @return the token type
     */
    public abstract String getTokenType();

    /**
     * Get the lexeme.
     *
     * @return the lexeme
     */
    public String getLexeme() {
        return lexeme;
    }

    /**
     * Get the string representation of the token.
     */
    @Override
    public String toString() {
        if(getTokenType().equals("")) {
            return "<" + lexeme + ">";
        }
        return "<" + getTokenType() + "," + lexeme + ">";
    }

    /**
     * Compare two tokens.
     *
     * @param other the other token
     * @return the result of the comparison
     */
    @Override
    public int compareTo(Token other) {
        return this.lexeme.compareTo(other.lexeme);
    }
}
