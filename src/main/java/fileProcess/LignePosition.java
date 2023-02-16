package fileProcess;

import beans.Direction;
import beans.PointLimite;
import beans.Position;
import exceptions.TendeuseException;
import org.apache.commons.lang3.StringUtils;
import util.MessagesConstantes;

public class LignePosition extends  AbstractConertisseurLigne {

    public LignePosition(String ligne) {
        super(ligne);
    }

    @Override
    protected boolean estLigneValide() {
        return StringUtils.isNotBlank(ligne) && ligne.matches("^[0-9] [0-9] (N|S|W|E)$");
    }

    @Override
    protected Position traitement() {
        String[] split = ligne.split(" ");
        Direction direction = Direction.getDirectionFromCode(split[2]);
        return new Position(Integer.valueOf(split[0]), Integer.valueOf(split[1]), direction);
    }
    public Position convert() throws TendeuseException {
        if (!estLigneValide()) {

            throw new TendeuseException(MessagesConstantes.ERREUR_FICHIER_FORMAT);
        }
        return traitement();
    }
}
