
package pieces;

/**
 * Class representing a Pawn chess piece.
 */
public class Pawn extends Piece {

    public Pawn(String color, String position) {
        super(color, position);
    }

    @Override
    public String[] possibleMoves() {
        // Example move logic
        return new String[] { getPosition() };
    }
}
