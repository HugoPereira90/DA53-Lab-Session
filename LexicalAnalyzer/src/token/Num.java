package token;

public class Num extends Token {

    float value;

    public Num(String lexeme, float value) {
        super(lexeme);
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String getTokenType() {
        return "NUM";
    }
}