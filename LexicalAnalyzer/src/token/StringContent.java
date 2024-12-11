package token;

public class StringContent extends Token {

    public StringContent(String lexeme) {
        super(lexeme);
    }

    @Override
    public String getTokenType() {
        return "STRING";
    }
}
