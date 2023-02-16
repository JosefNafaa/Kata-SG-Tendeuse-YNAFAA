package fileProcess;

import beans.PointLimite;
import exceptions.TendeuseException;
import org.apache.commons.lang3.StringUtils;
import util.MessagesConstantes;

public class LignePointLimite extends  AbstractConertisseurLigne{

    public LignePointLimite(String ligne) {
        super(ligne);
    }

    @Override
    protected boolean estLigneValide() {
        return StringUtils.isNotBlank(ligne) && ligne.matches("^[0-9] [0-9]$");
    }

    @Override
    protected PointLimite traitement() {

        String[] cooordonnees = ligne.split(" ");
        return new PointLimite(Integer.valueOf(cooordonnees[0]), Integer.valueOf(cooordonnees[1]));
    }
    public PointLimite convert() throws TendeuseException {
        if (!estLigneValide()) {

            throw new TendeuseException(MessagesConstantes.ERREUR_FICHIER_FORMAT);
        }
        return traitement();
    }


}
