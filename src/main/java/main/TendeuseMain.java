package main;

import beans.Position;
import exceptions.TendeuseException;
import fileProcess.FileProcessReader;
import fileProcess.FileReader;
import util.MessagesConstantes;

import java.util.List;

public class TendeuseMain {
    public static void main(final String[] args) throws TendeuseException {

    System.out.println("hna waw3rin");
        if(args == null || args.length == 0) {
            throw new TendeuseException(MessagesConstantes.ERREUR_FICHIER_NOM);
        }

        List<String> fileLine = FileReader.getInstance().read(args[0]);
        System.out.println(fileLine.get(0));

        List<Position> positions = new FileProcessReader(fileLine).process();

        /*logger.info("****************** Results **********************");
        for (int i=0 ; i < positions.size() ; i++) {
            logger.info("   " + i + " : Mower final position : " + positions.get(i));
        }
        logger.info("*************************************************");*/

        System.out.println(fileLine.get(0));
    }
}
