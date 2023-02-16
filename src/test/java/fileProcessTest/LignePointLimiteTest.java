package fileProcessTest;

import beans.PointLimite;
import exceptions.TendeuseException;
import fileProcess.LignePointLimite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LignePointLimiteTest {
    private final String commandLine;
    private final Boolean hasException;

    public LignePointLimiteTest(final String commandLine, Boolean result) {
        this.commandLine = commandLine;
        this.hasException = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[]{"5 2", true},
                new Object[]{"5 -2", false},
                new Object[]{"55", false},
                new Object[]{"", false},
                new Object[]{"5 5 N", false},
                new Object[]{"    5 5", false},
                new Object[]{"8 2   ", false},
                new Object[]{"R R", false},
                new Object[]{"5 G", false},
                new Object[]{null, false}
        );
    }

    @Test
    public void convert() {
        // Given
        LignePointLimite convertor = new LignePointLimite(commandLine);

        // When
        try {
            PointLimite pl = convertor.convert();

            // Then
            assertTrue(hasException);
            assertNotNull(commandLine);
            String[] split = commandLine.split(" ");
            assertEquals(Integer.valueOf(split[0]).intValue(), pl.getX());
            assertEquals(Integer.valueOf(split[1]).intValue(), pl.getY());
        } catch (TendeuseException e) {
            assertFalse(hasException);
        }
    }
}