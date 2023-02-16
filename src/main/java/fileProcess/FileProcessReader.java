package fileProcess;

import beans.Instruction;
import beans.PointLimite;
import beans.Position;
import beans.Tendeuse;
import exceptions.TendeuseException;
import util.MessagesConstantes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileProcessReader {


    private final List<Tendeuse> tendeuseList = new ArrayList<Tendeuse>();

    public FileProcessReader(final List<String> file) throws  TendeuseException {

        if (file == null || file.size() == 0) {

            throw new TendeuseException(MessagesConstantes.ERREUR_FICHIER_VIDE);
        }

        Iterator<String> iterator = file.iterator();

        String gardenLimitLine = iterator.next();
        PointLimite pointLimite = new LignePointLimite(gardenLimitLine).convert();

        while (iterator.hasNext()) {
            String positionMowerLine = iterator.next();
            Position position = new LignePosition(positionMowerLine).convert();

            if (!iterator.hasNext()) {

                throw new TendeuseException(MessagesConstantes.ERREUR_FICHIER_FORMAT);
            }

            String tendeuseCommands = iterator.next();
            List<Instruction> commands = new LigneInstruction(tendeuseCommands).convert();

            Tendeuse tendeuse = new Tendeuse( position,pointLimite, commands);
            tendeuseList.add(tendeuse);
        }
    }

    public List<Position> process() {
        List<Position> position = new ArrayList<Position>(tendeuseList.size());
        for(Tendeuse tendeuse : tendeuseList) {
            position.add(tendeuse.traitement());
        }
        return position;
    }
}
