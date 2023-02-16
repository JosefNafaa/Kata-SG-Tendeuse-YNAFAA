package fileProcess;

import beans.Instruction;
import beans.Position;
import exceptions.TendeuseException;
import org.apache.commons.lang3.StringUtils;
import util.MessagesConstantes;

import java.util.ArrayList;
import java.util.List;

public class LigneInstruction extends AbstractConertisseurLigne{

    public LigneInstruction(String ligne) {
        super(ligne);
    }

    @Override
    protected boolean estLigneValide() {
        return StringUtils.isNotBlank(ligne)
                && StringUtils.containsOnly(ligne,
                Instruction.AVANCER.getCode()
                        + Instruction.DROITE.getCode()
                        + Instruction.GAUCHE.getCode());
    }

    @Override
    public  List<Instruction> traitement() {
        List<Instruction> cmds = new ArrayList<>();
        char [] listeCmds = ligne.toCharArray();

        for (char c : listeCmds) {
            cmds.add(Instruction.getCommandeFromCode(String.valueOf(c)));
        }

        return cmds;
    }
    public  List<Instruction> convert() throws TendeuseException {
        if (!estLigneValide()) {

            throw new TendeuseException(MessagesConstantes.ERREUR_FICHIER_FORMAT);
        }
        return traitement();
    }
}
