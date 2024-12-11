package token;

public class Operator extends Token{

    public Operator(String lexeme) {
        super(lexeme);
    }

    @Override
    public String getTokenType() {
        return "OP";
    }
}
