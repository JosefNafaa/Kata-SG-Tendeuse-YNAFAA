package fileProcessTest;

import beans.Position;
import exceptions.TendeuseException;
import fileProcess.FileProcessReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class FileProcessReaderTest {

    private final List<String> file;
    private final List<String> result;

    public FileProcessReaderTest(List<String> file, List<String> result) {
        this.file = file;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[] {
                        Arrays.asList("8 2", "4 1 E", "GAAADA"),
                        Arrays.asList("5 2 E") },
                new Object[] {
                        Arrays.asList("8 4", "4 1 E", "GAAGDADA"),
                        Arrays.asList("5 4 E") },
                new Object[] {
                        Arrays.asList("5 5", "1 2 N", "GAGAGAGAA", "3 3 E",  "AADAADADDA"),
                        Arrays.asList("1 3 N", "5 1 E") },
                new Object[] {
                        Arrays.asList("5 5", "1 2 N", "GAAAAAAAGAGAGAA", "3 3 E",  "AAAAAAADAADADDA"),
                        Arrays.asList("1 3 N", "5 1 E") }
        );
    }

    @Test
    public void process() throws Exception {
        // Given
        FileProcessReader startEngine = new FileProcessReader(file);

        // When
        List<Position> positions = startEngine.process();

        // Then
        assertNotNull(positions);
        assertEquals(result.size(), positions.size());

        for (int i = 0 ; i < positions.size() ; i++) {
            assertNotNull(positions.get(i));
            assertEquals(result.get(i), positions.get(i).toString());
        }
    }







    @Test(expected= TendeuseException.class)
    public void process_whenWrongCommandLineSpace_throwInvaliFileException() throws Exception {

        // Given
        List<String> file = Arrays.asList("5 5", "1 2 N", "GAGA  GAGAA", "3 3 E",  "AADAADADDA");
        FileProcessReader startEngine = new FileProcessReader(file);

        // When
        startEngine.process();
    }

    @Test(expected=TendeuseException.class)
    public void process_whenWrongCommandLineInvalidCaracter_throwInvaliFileException() throws Exception {

        // Given
        List<String> file = Arrays.asList("5 5", "1 2 N", "GAGAHAGAA", "3 3 E",  "AADAADADDA");
        FileProcessReader startEngine = new FileProcessReader(file);

        // When
        startEngine.process();
    }

    @Test(expected=TendeuseException.class)
    public void process_whenWrongCommandLineInvalidEmpty_throwInvaliFileException() throws Exception {

        // Given
        List<String> file = Arrays.asList("5 5", "1 2 N", "", "3 3 E",  "AADAADADDA");
        FileProcessReader startEngine = new FileProcessReader(file);

        // When
        startEngine.process();
    }

    @Test(expected=TendeuseException.class)
    public void process_whenWrongGardenSizeInvalid_throwInvaliFileException() throws Exception {

        // Given
        List<String> file = Arrays.asList("5", "1 2 N", "GAGAAGAA", "3 3 E",  "AADAADADDA");
        FileProcessReader startEngine = new FileProcessReader(file);

        // When
        startEngine.process();
    }

    @Test(expected=TendeuseException.class)
    public void process_whenWrongGardenSizeInvalidNegative_throwInvaliFileException() throws Exception {

        // Given
        List<String> file = Arrays.asList("-5 5", "1 2 N", "GAGAAGAA", "3 3 E",  "AADAADADDA");
        FileProcessReader startEngine = new FileProcessReader(file);

        // When
        startEngine.process();
    }

    @Test(expected=TendeuseException.class)
    public void process_whenWrongGardenSizeInvalidCaracter_throwInvaliFileException() throws Exception {

        // Given
        List<String> file = Arrays.asList("5 T", "1 2 N", "GAGAAGAA", "3 3 E",  "AADAADADDA");
        FileProcessReader startEngine = new FileProcessReader(file);

        // When
        startEngine.process();
    }

    @Test(expected=TendeuseException.class)
    public void process_whenWrongGardenSizeInvalidEmpty_throwInvaliFileException() throws Exception {

        // Given
        List<String> file = Arrays.asList("", "1 2 N", "GAGAAGAA", "3 3 E",  "AADAADADDA");
        FileProcessReader startEngine = new FileProcessReader(file);

        // When
        startEngine.process();
    }

    @Test(expected=TendeuseException.class)
    public void process_whenWrongFileFormat_throwInvaliFileException() throws Exception {

        // Given
        List<String> file = Arrays.asList("5 5", "1 2 N");
        FileProcessReader startEngine = new FileProcessReader(file);

        // When
        startEngine.process();
    }

    @Test(expected=TendeuseException.class)
    public void process_whenEmptyFile_throwInvaliFileException() throws Exception {

        // Given
        FileProcessReader startEngine = new FileProcessReader(Collections.<String> emptyList());

        // When
        startEngine.process();
    }

    @Test(expected=TendeuseException.class)
    public void process_whenWrongInitialMowerPosition_throwInitialPositionMowerInvalidException() throws Exception {

        // Given
        List<String> file = Arrays.asList("5 5", "1 2 N", "GAGAAGAA", "3 7 E",  "AADAADADDA");
        FileProcessReader startEngine = new FileProcessReader(file);

        // When
        startEngine.process();
    }

    @Test(expected=TendeuseException.class)
    public void process_whenWrongInitialMowerPosition2_throwInitialPositionMowerInvalidException() throws Exception {

        // Given
        List<String> file = Arrays.asList("5 5", "1 5 N", "GAGAAGAA", "6 5 E",  "AADAADADDA");
        FileProcessReader startEngine = new FileProcessReader(file);

        // When
        startEngine.process();
    }
}
