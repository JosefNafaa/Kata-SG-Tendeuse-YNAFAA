package beansTest;

import beans.Direction;
import beans.PointLimite;
import beans.Position;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PositionAvancerTest {
    private final Position position;
    private final PointLimite limit;
    private final int resultX;
    private final int resultY;

    public PositionAvancerTest(final Position position, final PointLimite limit, final int resultX, final int resultY) {
        this.position = position;
        this.limit = limit;
        this.resultX = resultX;
        this.resultY = resultY;
    }



    @Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[] { new Position(5, 5, Direction.North), new PointLimite(5, 5), 5, 5 },
                new Object[] { new Position(5, 5, Direction.East), new PointLimite(5, 5), 5, 5 },
                new Object[] { new Position(0, 5, Direction.West), new PointLimite(5, 5), 0, 5 },
                new Object[] { new Position(5, 0, Direction.South), new PointLimite(5, 5), 5, 0 },
                new Object[] { new Position(5, 1, Direction.South), new PointLimite(5, 5), 5, 0 },
                new Object[] { new Position(2, 2, Direction.West), new PointLimite(5, 5), 1, 2 },
                new Object[] { new Position(2, 2, Direction.East), new PointLimite(5, 5), 3, 2 },
                new Object[] { new Position(2, 2, Direction.North), new PointLimite(5, 5), 2, 3 }
        );
    }

    @Test
    public void avancer() {
        // When
        position.avancer(limit);
        // Then
        assertEquals(position.getX(), resultX);
        assertEquals(position.getY(), resultY);
    }

    @Test
    public void should_return_false_when_coordonneX_out_of_Tendeuse(){
        PointLimite p=new PointLimite(5,5);
        Position ps= new Position(7, 5, Direction.North);
        boolean validerPoisition =ps.estPositionValide(p);
        assertEquals(validerPoisition, false);
    }
    @Test
    public void should_return_false_when_coordonneY_out_of_Tendeuse(){
        PointLimite p=new PointLimite(5,5);
        Position ps= new Position(3, 15, Direction.East);
        boolean validerPoisition =ps.estPositionValide(p);
        assertEquals(validerPoisition, false);
    }

    @Test
    public void should_return_false_when_coordonneXY_out_of_Tendeuse(){
        PointLimite p=new PointLimite(5,5);
        Position ps= new Position(23, 15, Direction.South);
        boolean validerPoisition =ps.estPositionValide(p);
        assertEquals(validerPoisition, false);
    }
    @Test
    public void should_return_false_when_coordonneY_negative_out_of_Tendeuse(){
        PointLimite p=new PointLimite(5,5);
        Position ps= new Position(3, -15, Direction.West);
        boolean validerPoisition =ps.estPositionValide(p);
        assertEquals(validerPoisition, false);
    }
    @Test
    public void should_return_false_when_coordonneX_negative_out_of_Tendeuse(){
        PointLimite p=new PointLimite(5,5);
        Position ps= new Position(-7, 5, Direction.North);
        boolean validerPoisition =ps.estPositionValide(p);
        assertEquals(validerPoisition, false);
    }
    @Test
    public void should_return_false_when_coordonneXY_negative_out_of_Tendeuse(){
        PointLimite p=new PointLimite(5,5);
        Position ps= new Position(-23, -15, Direction.South);
        boolean validerPoisition =ps.estPositionValide(p);
        assertEquals(validerPoisition, false);
    }
}
