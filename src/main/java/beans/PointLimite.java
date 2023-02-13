package beans;

import exceptions.TendeuseException;
import util.MessagesConstantes;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PointLimite {
    private int x, y;

    public PointLimite() {
        super();
        // TODO Auto-generated constructor stub
    }

    public PointLimite(int x, int y) {
        if (x < 0 || y < 0) {
            throw new TendeuseException(MessagesConstantes.ERREUR_POSITION_VALUE);
        }
        this.x = x;
        this.y = y;
    }


}
