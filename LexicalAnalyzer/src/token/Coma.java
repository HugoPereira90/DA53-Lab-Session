package token;

public class Coma extends Token{

    public Coma(String lexeme) {
        super(lexeme);
    }

    @Override
    public String getTokenType() {
        return "COMA";
    }
}
