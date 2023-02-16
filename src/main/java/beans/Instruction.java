package beans;

public enum Instruction {

    AVANCER("A" ,"Avancer"),
    DROITE("D","Tourner à droite"),
    GAUCHE("G","Tourner à gauche");

    private String code;

    private String libelleInstruction;
    private Instruction(String code,String libelleInstruction) {
        this.code = code;
        this.libelleInstruction=libelleInstruction;
    }

    public String getCode() {
        return code;
    }

    public String getLibelleInstruction() {
        return libelleInstruction;
    }

    public static Instruction getCommandeFromCode(final String code) {
        for (Instruction commande : Instruction.values()) {
            if (commande.getCode().equals(code)) {
                return commande;
            }
        }
        return null;
    }
}
