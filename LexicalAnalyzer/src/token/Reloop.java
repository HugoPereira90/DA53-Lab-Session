package token;

public class Reloop extends Token {

    public Reloop(String lexeme) {
        super(lexeme);
    }

    @Override
    public String getTokenType() {
        return "RELOOP";
    }
}
