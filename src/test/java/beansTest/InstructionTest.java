package beansTest;

import beans.Instruction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class InstructionTest {

    private final String code;
    private final Instruction commandResult;

    public InstructionTest(final String code, final Instruction commandResult) {
        this.code = code;
        this.commandResult = commandResult;
    }

    @Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[] { "A", Instruction.AVANCER },
                new Object[] { "G", Instruction.GAUCHE },
                new Object[] { "D", Instruction.DROITE }

        );
    }

    @Test
    public void should_getCommandeFromCode_with_correct_code() {
        // When
        Instruction commandeFromCode = Instruction.getCommandeFromCode(code);

        // Then
        assertEquals(commandResult, commandeFromCode);
    }
    @Test
    public void should_return_null_witth_wrong_code(){
        Instruction commandeFromCode1 = Instruction.getCommandeFromCode("Z");

        // Then
        assertEquals(null, commandeFromCode1);

        Instruction commandeFromCode2 = Instruction.getCommandeFromCode("1");

        // Then
        assertEquals(null, commandeFromCode2);
    }

    @Test
    public void souhld_return_null_with_space(){
    Instruction commandeFromCode = Instruction.getCommandeFromCode(" ");

    // Then
    assertEquals(null, commandeFromCode);

    }
    @Test
    public void souhld_return_null_empty_code(){
        Instruction commandeFromCode = Instruction.getCommandeFromCode("");

        // Then
        assertEquals(null, commandeFromCode);

    }


}
