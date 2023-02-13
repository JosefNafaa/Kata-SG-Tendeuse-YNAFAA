package beansTest;

import beans.Direction;
import beans.PointLimite;
import exceptions.TendeuseException;
import org.junit.Test;



public class PointLimitTest {


    @Test(expected = TendeuseException.class)
    public void should_throw_an_exception_when_x_is_negative() {
            PointLimite p=new PointLimite(-1, 0);
    }

    @Test(expected = TendeuseException.class)
    public void should_throw_an_exception_when_y_is_negative() {

        PointLimite p=new PointLimite(0, -5);
    }

    @Test(expected = TendeuseException.class)
    public void should_throw_an_exception_when_both_are_negatives() {

        PointLimite p=new PointLimite(-1, -1);
    }
}
