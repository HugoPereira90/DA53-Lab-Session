package token;

public class OpenParentesis extends Token {

    public OpenParentesis(String lexeme) {
        super(lexeme);
    }

    @Override
    public String getTokenType() {
        return "OPEN_PARENTESIS";
    }
}

