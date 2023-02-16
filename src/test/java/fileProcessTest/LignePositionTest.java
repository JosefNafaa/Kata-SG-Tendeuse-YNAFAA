package fileProcessTest;
import beans.Direction;
import beans.Position;
import exceptions.TendeuseException;
import fileProcess.LignePosition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class LignePositionTest {

    private final String commandLine;
    private final Boolean hasException;

    public LignePositionTest(final String commandLine, Boolean result) {
        this.commandLine = commandLine;
        this.hasException = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[] { "5 2 N", true },
                new Object[] { "8 3 S", true },
                new Object[] { "5 7 E", true },
                new Object[] { "7 2 W", true },
                new Object[] { "55 W", false },
                new Object[] { "N 5 5", false },
                new Object[] { "N 55", false },
                new Object[] { "    5 5 N", false },
                new Object[] { "8 2 E  ", false },
                new Object[] { "R R 8", false },
                new Object[] { "-1 2 W", false },
                new Object[] { null, false }
        );
    }

    @Test
    public void convert() {
        // Given
        LignePosition convertor = new LignePosition(commandLine);

        //When
        try {
            Position position = convertor.convert();

            // Then
            assertTrue(hasException);
            assertNotNull(commandLine);
            String[] split = commandLine.split(" ");
            assertEquals(Integer.valueOf(split[0]).intValue(), position.getX());
            assertEquals(Integer.valueOf(split[1]).intValue(), position.getY());
            assertEquals(Direction.getDirectionFromCode(split[2]), position.getDirection());
        } catch (TendeuseException e) {
            assertFalse(hasException);
        }
    }
}
