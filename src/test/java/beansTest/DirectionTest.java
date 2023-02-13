package beansTest;

import beans.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

    @Test
    public void should_return_west_when_direction_north_and_turn_left(){
        Direction d=Direction.North;
        Direction left=Direction.West;
        assertEquals(left, d.getLeftDirection());

    }
    @Test
    public void should_return_east_when_direction_north_and_turn_right(){
        Direction d=Direction.North;
        Direction right=Direction.East;
        assertEquals(right, d.getRightDirection());

    }

    @Test
    public void should_return_east_when_direction_south_and_turn_left(){
        Direction d=Direction.South;
        Direction left=Direction.East;
        assertEquals(left, d.getLeftDirection());

    }
    @Test
    public void should_return_west_when_direction_south_and_turn_right(){
        Direction d=Direction.South;
        Direction right=Direction.West;
        assertEquals(right, d.getRightDirection());

    }
    @Test
    public void should_return_south_when_direction_west_and_turn_left(){
        Direction d=Direction.West;
        Direction left=Direction.South;
        assertEquals(left, d.getLeftDirection());

    }
    @Test
    public void should_return_north_when_direction_west_and_turn_right(){
        Direction d=Direction.West;
        Direction right=Direction.North;
        assertEquals(right, d.getRightDirection());

    }
    @Test
    public void should_return_north_when_direction_east_and_turn_left(){
        Direction d=Direction.East;
        Direction left=Direction.North;
        assertEquals(left, d.getLeftDirection());

    }
    @Test
    public void should_return_south_when_direction_east_and_turn_right(){
        Direction d=Direction.East;
        Direction right=Direction.South;
        assertEquals(right, d.getRightDirection());

    }
}
