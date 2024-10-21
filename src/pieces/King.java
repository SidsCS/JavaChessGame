
package pieces;

/**
 * Class representing a King chess piece.
 */
public class King extends Piece {

    public King(String color, String position) {
        super(color, position);
    }

    @Override
    public String[] possibleMoves() {
        // Example move logic
        return new String[] { getPosition() };
    }
}
