package token;

public class CloseParentesis extends Token {

    public CloseParentesis(String lexeme) {
        super(lexeme);
    }

    @Override
    public String getTokenType() {
        return "CLOSE_PARENTESIS";
    }
}