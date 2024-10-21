
package pieces;

/**
 * Class representing a Knight chess piece.
 */
public class Knight extends Piece {

    public Knight(String color, String position) {
        super(color, position);
    }

    @Override
    public String[] possibleMoves() {
        // Example move logic
        return new String[] { getPosition() };
    }
}
