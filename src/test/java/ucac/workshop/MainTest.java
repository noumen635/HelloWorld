package ucac.workshop;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {
    @org.junit.Test
    public void main() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Main.main(new String[]{});
        assertEquals("Hello world !\n", outContent.toString());
    }
}