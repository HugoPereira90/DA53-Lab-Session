import token.Token;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;


/**
 * Main class for the lexical analyzer.
 */
public class Main{
    private static final File file = new File(".\\Resources\\test1.txt");

    /**
     * Main method for the lexical analyzer.
     *
     * @param args the command line arguments
     * @throws IOException if an I/O error occurs
     */
    public static void main(String[] args) throws IOException {

        // Create a reader for the input file
        Reader reader = new FileReader(file);

        // Create a scanner and a symbol table
        Scanner scanner = new Scanner(reader);
        SymbolTable symbolTable = new SymbolTable();

        // Create a lexer
        Lexer lexer = new Lexer(scanner, symbolTable);

        // Get the first token
        Token token = lexer.getNextSymbol();;

        // Print the tokens
        while (!Objects.equals(token.getLexeme(), "EOF")){
            if(!Objects.equals(token.getLexeme(), "EOL")){
                System.out.print(token);
            }else{
                System.out.print("\n");
            }
            token = lexer.getNextSymbol();
        }

        // Print the symbol table
        symbolTable.printTable();
    }
}
