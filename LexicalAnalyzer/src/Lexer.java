import token.*;

import java.io.IOException;


/**
 * Lexical analyzer for the BASIC programming language.
 */
public class Lexer {
    private Scanner scanner;
    private SymbolTable symbolTable;

    private int numLigne = 1;

    public Lexer(Scanner scanner, SymbolTable symbolTable) {
        this.scanner = scanner;
        this.symbolTable = symbolTable;
    }

    /**
     * Get the next token from the input.
     *
     * @return the next token
     * @throws IOException if an I/O error occurs
     */
    public Token getNextSymbol() throws IOException {
        char currentChar;

        // Skip white spaces and comments
        do {
            currentChar = scanner.peek();
            if (currentChar == '\n') {
                scanner.get();
                numLigne++;
                return new Keyword("EOL");
            } else if (Character.isWhitespace(currentChar)) {
                scanner.get();  // Consume the white space
            } else if (currentChar == 'R') {  // Vérifier si c'est le début de "REM"
                StringBuilder remCheck = new StringBuilder();
                while (Character.isLetterOrDigit(scanner.peek())) {
                    remCheck.append(scanner.get());
                }
                String rem = remCheck.toString();  // Regarder les 3 prochains caractères (par exemple 'REM')
                if (rem.equals("REM")) {
                    while (scanner.peek() != '\n' && scanner.hasNext()) {
                        scanner.get();  // Consommer les commentaires jusqu'à la fin de ligne
                    }
                }
            } else {
                break;
            }
        } while (scanner.hasNext());

        if (!scanner.hasNext()) {
            return new Keyword("EOF");
        }

        // Recognize numbers
        if (Character.isDigit(currentChar)) {
            StringBuilder number = new StringBuilder();
            while (Character.isDigit(scanner.peek())) {
                number.append(scanner.get());
            }

            return new Num(number.toString(), Float.parseFloat(number.toString()));
        }

        if(currentChar == '"'){
            StringBuilder string = new StringBuilder();
            scanner.get();  // Consume the "
            while (scanner.peek() != '"' && scanner.hasNext()) {
                string.append(scanner.get());
            }

            if (!scanner.hasNext()) {
                throw new RuntimeException("String not closed");
            }

            scanner.get();  // Consume the "
            return new StringContent(string.toString());
        }

        // Recognize identifiers and keywords
        if (Character.isLetter(currentChar)) {
            StringBuilder identifier = new StringBuilder();
            while (Character.isLetterOrDigit(scanner.peek())) {
                identifier.append(scanner.get());
            }
            String id = identifier.toString();

            // Example keywords: "let", "if", "then", "goto", "print"
            switch (id.toUpperCase()) {
                case "PRINT", "LET", "IF", "THEN", "GOTO", "INPUT", "GOSUB", "RETURN", "END" -> {
                    return new Keyword(id);
                }
                default -> {
                    // Add identifier to the symbol table if it's new
                    Token idToken = new Identifier(id);
                    symbolTable.add(idToken, numLigne);
                    return idToken;
                }
            }
        }

        // Recognize assignment
        if (currentChar == '=') {
            return new Assign(Character.toString(scanner.get()));
        }

        // Recognize operators (e.g., +, -, *)
        if ("+-*/=".indexOf(currentChar) != -1) {
            return new Operator(Character.toString(scanner.get()));
        }

        // Recognize comparison operators >=
        if (currentChar == '>' && scanner.peek() == '=') {
            scanner.get();  // Consume '>'
            scanner.get();  // Consume '='
            return new Reloop(">=");
        }

        // Recognize comparison operators <=
        if (currentChar == '<' && scanner.peek() == '=') {
            scanner.get();  // Consume '<'
            scanner.get();  // Consume '='
            return new Reloop("<=");
        }

        // Recognize comparison operators <>
        if (currentChar == '<' && scanner.peek() == '>') {
            scanner.get();  // Consume '<'
            scanner.get();  // Consume '>'
            return new Reloop("<>");
        }

        // Recognize comparison operators <
        if (currentChar == '<') {
            return new Reloop(Character.toString(scanner.get()));
        }

        // Recognize comparison operators >
        if (currentChar == '>') {
            return new Reloop(Character.toString(scanner.get()));
        }

        // Recognize symbols (
        if (currentChar == '(') {
            return new OpenParentesis(Character.toString(scanner.get()));
        }

        // Recognize symbols )
        if (currentChar == ')') {
            return new CloseParentesis(Character.toString(scanner.get()));
        }

        // Recognize symbols ,
        if (currentChar == ',') {
            return new Coma(Character.toString(scanner.get()));
        }

        throw new RuntimeException("Unknown character: " + currentChar);
    }
}
