package beansTest;

import beans.Point;
import exceptions.TendeuseException;
import org.junit.Test;


public class PointTest {

    @Test(expected = TendeuseException.class)
    public void should_throw_exception_with_negative_values_point(){
        Point p=new Point(-2,-1);

    }
}
