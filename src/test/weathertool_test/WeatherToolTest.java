package weathertool_test;

import main.WeatherTool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class WeatherToolTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayInputStream inContent;
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldBeValidZipCode() {
        inContent = new ByteArrayInputStream("95762".getBytes());
        System.setIn(inContent);
        WeatherTool.getZipCode();

        Assertions.assertEquals("Enter a zipcode:", outContent.toString().trim());

        Assertions.assertNotEquals("Please enter a valid zip code.", outContent.toString().trim());
        Assertions.assertNotEquals("Zip code must be 5 digits.", outContent.toString().trim());
        Assertions.assertNotEquals("Zip code must contain numeric values only.", outContent.toString().trim());

        System.setIn(originalIn);
    }

    @Test
    public void shouldBeInvalidZipCodeLength() {
        inContent = new ByteArrayInputStream("333\n95762".getBytes());
        System.setIn(inContent);
        WeatherTool.getZipCode();
        String expected = "Enter a zipcode:\nZip code must be 5 digits.\nEnter a zipcode:".replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
        Assertions.assertEquals(expected, outContent.toString().trim());
        System.setIn(originalIn);

        System.setOut(originalOut);
        inContent = new ByteArrayInputStream("666666\n95762".getBytes());
        System.setIn(inContent);
        WeatherTool.getZipCode();
        Assertions.assertEquals(expected, outContent.toString().trim());
    }

    @Test
    public void shouldBeInvalidZipCodeCharacters() {
        inContent = new ByteArrayInputStream("aaa\n95762".getBytes());
        System.setIn(inContent);
        WeatherTool.getZipCode();
        String expected = "Enter a zipcode:\nZip code must contain numeric values only.\nEnter a zipcode:".replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
        Assertions.assertEquals(expected, outContent.toString().trim());
        System.setIn(originalIn);

        System.setOut(originalOut);
        inContent = new ByteArrayInputStream("sdlkfj\n95762".getBytes());
        System.setIn(inContent);
        WeatherTool.getZipCode();
        Assertions.assertEquals(expected, outContent.toString().trim());

        System.setOut(originalOut);
        inContent = new ByteArrayInputStream("33slj\n95762".getBytes());
        System.setIn(inContent);
        WeatherTool.getZipCode();
        Assertions.assertEquals(expected, outContent.toString().trim());

        System.setOut(originalOut);
        inContent = new ByteArrayInputStream("oij98\n95762".getBytes());
        System.setIn(inContent);
        WeatherTool.getZipCode();
        Assertions.assertEquals(expected, outContent.toString().trim());
    }
}
