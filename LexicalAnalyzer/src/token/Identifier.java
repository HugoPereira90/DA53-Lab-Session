package token;

public class Identifier extends Token {

    public Identifier(String lexeme) {
        super(lexeme);
    }

    @Override
    public String getTokenType() {
        return "ID";
    }
}
