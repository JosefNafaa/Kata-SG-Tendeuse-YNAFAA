package beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter

public class Position {
    private int x;
    private int y;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }


    public boolean estPositionValide(PointLimite pLimite)
    {
        return x >=0 &&  y >= 0 && x <= pLimite.getX() &&  y <= pLimite.getY();
    }
    public void avancer(final PointLimite pLimit) {

        switch(direction) {
            case North :
                if (y < pLimit.getY()) { y += 1; }
                break;
            case South :
                if (y > 0) { y -= 1; }
                break;
            case East :
                if (x < pLimit.getX()) { x += 1; }
                break;
            case West :
                if (x > 0) { x -= 1; }
                break;
        }
    }
    public void tournerDroite() {
        direction = direction.getRightDirection();
    }

    public void tournerGauche() {
        direction = direction.getLeftDirection();
    }

    public Position clone() {
        return new Position(this.x, this.y, this.direction);
    }

    @Override
    public String toString() {
        return
                "" + x +
                " " + y +
                " " + direction;
    }
}
