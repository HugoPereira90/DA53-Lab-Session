import token.Token;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

public class Main{
    private static final File file = new File(".\\Resources\\test1.txt");

    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader(file);
        Scanner scanner = new Scanner(reader);
        SymbolTable symbolTable = new SymbolTable();
        Lexer lexer = new Lexer(scanner, symbolTable);

        Token token = lexer.getNextSymbol();;

        while (!Objects.equals(token.getLexeme(), "EOF")){
            if(!Objects.equals(token.getLexeme(), "EOL")){
                System.out.print(token);
            }else{
                System.out.print("\n");
            }
            token = lexer.getNextSymbol();
        }

        symbolTable.printTable();
    }
}
