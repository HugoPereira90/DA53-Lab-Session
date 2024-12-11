public class SymbolEntry {
    private String lexeme;
    private int firstOccurrenceLine;

    public SymbolEntry(String lexeme, int firstOccurrenceLine) {
        this.lexeme = lexeme;
        this.firstOccurrenceLine = firstOccurrenceLine;
    }

    public String getLexeme() {
        return lexeme;
    }

    public int getFirstOccurrenceLine() {
        return firstOccurrenceLine;
    }

    @Override
    public String toString() {
        return "Lexeme: " + lexeme + ", First occurrence: Line " + firstOccurrenceLine;
    }
}
