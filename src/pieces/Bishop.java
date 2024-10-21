
package pieces;

/**
 * Class representing a Bishop chess piece.
 */
public class Bishop extends Piece {

    public Bishop(String color, String position) {
        super(color, position);
    }

    @Override
    public String[] possibleMoves() {
        // Example move logic
        return new String[] { getPosition() };
    }
}
