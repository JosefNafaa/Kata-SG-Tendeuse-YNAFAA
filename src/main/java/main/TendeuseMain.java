package main;

import beans.Position;
import exceptions.TendeuseException;
import fileProcess.FileProcessReader;
import fileProcess.FileReader;
import util.MessagesConstantes;
import java.util.List;

import org.apache.logging.log4j.Logger;

public class TendeuseMain {
    //static final Logger logger = Logger.getLogger(TendeuseMain.class);

    public static void main(final String[] args) throws TendeuseException {

    System.out.println("Résultat final :");
        if(args == null || args.length == 0) {
            throw new TendeuseException(MessagesConstantes.ERREUR_FICHIER_NOM);
        }

        List<String> fileLine = FileReader.getInstance().read(args[0]);

        List<Position> positions = new FileProcessReader(fileLine).process();

        /*logger.info("****************** Results **********************");
        for (int i=0 ; i < positions.size() ; i++) {
            logger.info("   " + i + " : Mower final position : " + positions.get(i));
        }
        logger.info("*************************************************");*/

        for (int i=0 ; i < positions.size() ; i++) {
            System.out.println("La tendeuse numéro " + (i+1) + " a comme  Position finale  : " + positions.get(i));
        }
    }
}
