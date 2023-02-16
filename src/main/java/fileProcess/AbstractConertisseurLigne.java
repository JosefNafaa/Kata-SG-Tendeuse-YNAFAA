package fileProcess;

import exceptions.TendeuseException;
import util.MessagesConstantes;

public abstract class AbstractConertisseurLigne<T> {

    protected final String ligne;

    protected AbstractConertisseurLigne(final String ligne) {
        this.ligne = ligne;
    }

    protected abstract boolean estLigneValide();
    protected abstract T traitement();

    public T convert() throws TendeuseException {
        if (!estLigneValide()) {

            throw new TendeuseException(MessagesConstantes.ERREUR_FICHIER_FORMAT);
        }
        return traitement();
    }
}
