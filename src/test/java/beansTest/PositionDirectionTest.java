package beansTest;

import beans.Direction;
import beans.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionDirectionTest {

    @Test
    public void tournerDirectionDroite() {

        // When
        Position position=new Position(5, 8, Direction.North);
        Position clonePosition = position.clone();
        clonePosition.tournerDroite();

        // Then
        assertEquals(clonePosition.getX(), 5);
        assertEquals(clonePosition.getY(), 8);
        assertEquals(clonePosition.getDirection(),  Direction.East);
    }

    @Test
    public void tourenRightDirectionGauche() {
        // When
        Position position=new Position(5, 8, Direction.North);
        Position clonePosition = position.clone();
        clonePosition.tournerGauche();

        // Then
        assertEquals(clonePosition.getX(), 5);
        assertEquals(clonePosition.getY(), 8);
        assertEquals(clonePosition.getDirection(), Direction.West);
    }
}
