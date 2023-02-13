package beans;

import exceptions.TendeuseException;
import util.MessagesConstantes;

import java.util.List;

public class Tendeuse {
    private final Position position;
    private final PointLimite limite;
    private final List<Instruction> cmds;

    public Tendeuse(Position position, PointLimite limite, List<Instruction> cmds) {
        if (!position.estPositionValide(limite)) {
            //logger.error(MessagesConstantes.ERREUR_POSITION_INITIALE);
            throw new TendeuseException(MessagesConstantes.ERREUR_POSITION_INITIALE);
        }
        this.position = position;
        this.limite = limite;
        this.cmds = cmds;
    }
    public Position traitement() {
        for(Instruction cmd : cmds) {
            excuterInstruction(cmd);
        }
        return position;
    }
    private void excuterInstruction(final Instruction cmd) {
        switch(cmd) {
            case AVANCER :
                position.avancer(limite);
                break;
            case DROITE :
                position.tournerDroite();
                break;
            case GAUCHE :
                position.tournerGauche();
                break;
        }
    }
}
