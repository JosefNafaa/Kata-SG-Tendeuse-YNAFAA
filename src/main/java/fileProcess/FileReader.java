package fileProcess;

import exceptions.TendeuseException;
import util.MessagesConstantes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {



    private static FileReader instance;

    private FileReader() {};

    public static FileReader getInstance() {
        if(instance == null) {
            instance = new FileReader();
        }
        return instance;
    }

    public List<String> read(final String fileName) throws TendeuseException {
        List<String> fileLine = new ArrayList<String>();

        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                fileLine.add(line);
            }
            scanner.close();
        }
       catch (FileNotFoundException e) {

            throw new TendeuseException(MessagesConstantes.ERREUR_FICHIER_INEXISTANT);
        }
        if (fileLine.size() == 0 || fileLine==null)
            throw new TendeuseException(MessagesConstantes.ERREUR_FICHIER_VIDE);
        return fileLine;
    }
}
