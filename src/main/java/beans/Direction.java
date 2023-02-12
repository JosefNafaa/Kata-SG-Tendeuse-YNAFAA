package beans;

public enum Direction {
    NORTH('N', 0, 1),
    EAST('E', 1, 0),
    WEST('W', -1, 0),
    SOUTH('S', 0, -1);

    char codeORientation;
    int coordonneX;
    int coordonneY;

    Direction(char codeORientation, int coordonneX, int coordonneY) {
        this.coordonneX = coordonneX;
        this.coordonneY = coordonneY;
        this.codeORientation = codeORientation;
    }

    public char getCodeORientation() {
        return codeORientation;
    }

    public int getCoordonneX() {
        return coordonneX;
    }

    public int getCoordonneY() {
        return coordonneY;
    }
}
