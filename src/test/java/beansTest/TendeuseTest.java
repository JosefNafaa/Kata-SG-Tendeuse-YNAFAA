package beansTest;

import beans.*;
import exceptions.TendeuseException;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class TendeuseTest {

    @Test
    public void should_return_final_position_with_initial_position_is_valid_and_first_direction_west() {

        List<Instruction> list = Arrays.asList(Instruction.AVANCER, Instruction.GAUCHE, Instruction.AVANCER);
        Tendeuse t = new Tendeuse(new Position(1, 5, Direction.West), new PointLimite(3, 8),
                list);
        Position finalPosition =new Position(0, 4, Direction.South);
        Position resultPosition = t.traitement();
        assertEquals(finalPosition.getX(), resultPosition.getX());
        assertEquals(finalPosition.getY(), resultPosition.getY());
        assertEquals(finalPosition.getDirection(), resultPosition.getDirection());

        }
    @Test
    public void should_return_final_position_with_initial_position_is_valid_and_first_direction_east() {

        List<Instruction> list = Arrays.asList(Instruction.AVANCER, Instruction.AVANCER, Instruction.AVANCER,Instruction.DROITE);
        Tendeuse t = new Tendeuse(new Position(1, 1, Direction.East), new PointLimite(2, 2),
                list);
        Position finalPosition =new Position(2, 1, Direction.South);
        Position resultPosition = t.traitement();
        assertEquals(finalPosition.getX(), resultPosition.getX());
        assertEquals(finalPosition.getY(), resultPosition.getY());
        assertEquals(finalPosition.getDirection(), resultPosition.getDirection());

    }
    @Test
    public void should_return_final_position_with_initial_position_is_valid_and_first_direction_north() {

        List<Instruction> list = Arrays.asList(Instruction.AVANCER, Instruction.AVANCER, Instruction.AVANCER,Instruction.GAUCHE);
        Tendeuse t = new Tendeuse(new Position(1, 1, Direction.North), new PointLimite(2, 2),
                list);
        Position finalPosition =new Position(1, 2, Direction.West);
        Position resultPosition = t.traitement();
        assertEquals(finalPosition.getX(), resultPosition.getX());
        assertEquals(finalPosition.getY(), resultPosition.getY());
        assertEquals(finalPosition.getDirection(), resultPosition.getDirection());

    }
    @Test
    public void should_return_final_position_with_initial_position_is_valid_and_first_direction_south() {

        List<Instruction> list = Arrays.asList(Instruction.AVANCER, Instruction.AVANCER, Instruction.AVANCER,Instruction.GAUCHE);
        Tendeuse t = new Tendeuse(new Position(1, 1, Direction.South), new PointLimite(2, 2),
                list);
        Position finalPosition =new Position(1, 0, Direction.East);
        Position resultPosition = t.traitement();
        assertEquals(finalPosition.getX(), resultPosition.getX());
        assertEquals(finalPosition.getY(), resultPosition.getY());
        assertEquals(finalPosition.getDirection(), resultPosition.getDirection());

    }
    @Test(expected = TendeuseException.class)
    public void should_throw_exception_when_initial_position_out_of_bound(){
        List<Instruction> list = Arrays.asList(Instruction.AVANCER, Instruction.AVANCER, Instruction.AVANCER,Instruction.GAUCHE);
        Tendeuse t = new Tendeuse(new Position(6, 1, Direction.South), new PointLimite(2, 2),
                list);

            Position resultPosition = t.traitement();

    }

    @Test
    public void should_throw_exception_with_empty_list_instructions(){
       //

    }

    }
