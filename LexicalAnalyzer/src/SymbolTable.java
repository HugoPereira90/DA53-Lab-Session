import token.Token;

import java.util.Map;
import java.util.TreeMap;


/**
 * Symbol table for the BASIC programming language.
 */
public class SymbolTable {
    private final Map<Token, SymbolEntry> symbolTable = new TreeMap<>();

    public SymbolTable() {
    }


    /**
     * Add a token to the symbol table.
     *
     * @param token the token to add
     * @param line  the line number of the first occurrence of the token
     */
    public void add(Token token, int line) {
        if (!symbolTable.containsKey(token)) {
            symbolTable.put(token, new SymbolEntry(token.getLexeme(), line));
        }
    }

    /**
     * Get the symbol entry for a token.
     *
     * @param token the token to get the symbol entry for
     * @return the symbol entry
     */
    public SymbolEntry getSymbolEntry(Token token) {
        return symbolTable.get(token);
    }

    /**
     * Print the symbol table.
     */
    public void printTable() {
        System.out.println("\nSymbol Table:");
        for (Map.Entry<Token, SymbolEntry> entry : symbolTable.entrySet()) {
            System.out.println("Token.Token: " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
