import token.Token;

import java.util.Map;
import java.util.TreeMap;

public class SymbolTable {
    private final Map<Token, SymbolEntry> symbolTable = new TreeMap<>();

    public SymbolTable() {
    }

    public void add(Token token, int line) {
        if (!symbolTable.containsKey(token)) {
            symbolTable.put(token, new SymbolEntry(token.getLexeme(), line));
        }
    }

    public SymbolEntry getSymbolEntry(Token token) {
        return symbolTable.get(token);
    }

    public void printTable() {
        System.out.println("\nSymbol Table:");
        for (Map.Entry<Token, SymbolEntry> entry : symbolTable.entrySet()) {
            System.out.println("Token.Token: " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
