/**
 * SymbolEntry class represents an entry in the symbol table.
 * It contains the lexeme and the line number of the first occurrence of the lexeme.
 */
public class SymbolEntry {
    private String lexeme;
    private int firstOccurrenceLine;

    public SymbolEntry(String lexeme, int firstOccurrenceLine) {
        this.lexeme = lexeme;
        this.firstOccurrenceLine = firstOccurrenceLine;
    }

    /**
     * Get the lexeme of the symbol entry.
     *
     * @return the lexeme
     */
    public String getLexeme() {
        return lexeme;
    }

    /**
     * Get the line number of the first occurrence of the lexeme.
     *
     * @return the line number
     */
    public int getFirstOccurrenceLine() {
        return firstOccurrenceLine;
    }


    @Override
    public String toString() {
        return "Lexeme: " + lexeme + ", First occurrence: Line " + firstOccurrenceLine;
    }
}
