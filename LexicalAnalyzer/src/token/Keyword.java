package token;

public class Keyword extends Token {

    public Keyword(String lexeme) {
        super(lexeme);
    }

    @Override
    public String getTokenType() {
        return "";
    }
}