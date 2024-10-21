
package pieces;

/**
 * Abstract class representing a chess piece.
 */
public abstract class Piece {
    protected String color;
    protected String position;

    public Piece(String color, String position) {
        this.color = color;
        this.position = position;
    }

    public abstract String[] possibleMoves();

    public String getColor() {
        return color;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
