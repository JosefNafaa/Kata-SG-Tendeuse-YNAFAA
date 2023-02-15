package beans;

public enum Instruction {
    GAUCHE('G', "Tourner à gauche"),
    DROITE('D', "tourner à droite"),
    AVANCER('A', "avancer");

    private char libelleInstruction;
    private String messageInstruction;

     Instruction(char libelleInstruction, String messageInstruction) {
        this.libelleInstruction = libelleInstruction;
        this.messageInstruction = messageInstruction;
    }

    public char getLibelleInstruction() {
        return libelleInstruction;
    }

    public String getMessageInstruction() {
        return messageInstruction;
    }
    public static Instruction getCommandeFromCode(final char code) {
        for (Instruction commande : Instruction.values()) {
            if (commande.getLibelleInstruction()==code) {
                return commande;
            }
        }
        return null;
    }
}
