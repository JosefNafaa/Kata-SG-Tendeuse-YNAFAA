package beans;

import exceptions.TendeuseException;
import util.MessagesConstantes;

public class Point {
    private int x, y;

    public Point() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Point(int x, int y) {
        if (x < 0 || y < 0) {
            throw new TendeuseException(MessagesConstantes.ERREUR_POSITION_VALUE);
        }
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
