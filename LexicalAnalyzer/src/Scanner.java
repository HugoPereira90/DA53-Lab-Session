import java.io.IOException;
import java.io.Reader;

public class Scanner {
    private Reader reader;
    private int currentChar;
    private int currentLine;

    public Scanner(Reader reader) throws IOException {
        this.reader = reader;
        this.currentChar = reader.read();
        this.currentLine = 1;
    }

    public char peek() throws IOException {
        return (char) currentChar;
    }

    public char get() throws IOException {
        char charToReturn = (char) currentChar;
        currentChar = reader.read();
        return charToReturn;
    }

    public int getCurrentLine() {
        return currentLine;
    }

    public boolean hasNext() {
        return currentChar != -1;
    }
}
