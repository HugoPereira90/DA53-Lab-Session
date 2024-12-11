package token;

public class Assign extends Token {

    public Assign(String lexeme) {
        super(lexeme);
    }

    @Override
    public String getTokenType() {
        return "";
    }
}
