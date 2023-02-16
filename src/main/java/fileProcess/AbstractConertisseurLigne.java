package fileProcess;



public abstract class AbstractConertisseurLigne<T> {

    protected final String ligne;

    protected AbstractConertisseurLigne(final String ligne) {
        this.ligne = ligne;
    }

    protected abstract boolean estLigneValide();
    protected abstract T traitement();

}
