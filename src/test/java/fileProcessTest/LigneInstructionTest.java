package fileProcessTest;

import beans.Instruction;
import exceptions.TendeuseException;
import fileProcess.LigneInstruction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LigneInstructionTest {
    private final String instruction;
    private final Boolean hasException;

    public LigneInstructionTest(final String instruction, Boolean result) {
        this.instruction = instruction;
        this.hasException = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[] { "GDAAGAADAA", true },
                new Object[] { "GAA ADA", false },
                new Object[] { "", false },
                new Object[] { "QSDFQSDF", false },
                new Object[] { "    GADAAGA", false },
                new Object[] { "GADAAGA   ", false },
                new Object[] { "11111", false },
                new Object[] { "  11111", false },
                new Object[] { "11111  ", false },
                new Object[] { null, false }
        );
    }

    @Test
    public void convert() {
        // Given
        LigneInstruction convertor = new LigneInstruction(instruction);

        //When
        try {
            List<Instruction> lCmds = convertor.convert();

            // Then
            assertTrue(hasException);
            assertNotNull(lCmds);
            assertEquals(instruction.length(), lCmds.size());

            char[] charArrayCmds = instruction.toCharArray();

            for (int i = 0; i < charArrayCmds.length; i++) {
                assertEquals(String.valueOf(charArrayCmds[i]), lCmds.get(i).getCode());
            }
        } catch (TendeuseException e) {
            assertFalse(hasException);
        }
    }
}
