import java.io.IOException;
import java.io.Reader;


/**
 * Scanner for the BASIC programming language.
 */
public class Scanner {
    private Reader reader;
    private int currentChar;
    private int currentLine;

    public Scanner(Reader reader) throws IOException {
        this.reader = reader;
        this.currentChar = reader.read();
        this.currentLine = 1;
    }

    /**
     * Get the next character from the input.
     *
     * @return the next character
     * @throws IOException if an I/O error occurs
     */
    public char peek() throws IOException {
        return (char) currentChar;
    }

    /**
     * Get the next character from the input and consume it.
     *
     * @return the next character
     * @throws IOException if an I/O error occurs
     */
    public char get() throws IOException {
        char charToReturn = (char) currentChar;
        currentChar = reader.read();
        return charToReturn;
    }

    /**
     * Get the current line number.
     *
     * @return the current line number
     */
    public int getCurrentLine() {
        return currentLine;
    }

    /**
     * Check if there are more characters in the input.
     *
     * @return true if there are more characters, false otherwise
     */
    public boolean hasNext() {
        return currentChar != -1;
    }
}
