
package pieces;

/**
 * Class representing a Queen chess piece.
 */
public class Queen extends Piece {

    public Queen(String color, String position) {
        super(color, position);
    }

    @Override
    public String[] possibleMoves() {
        // Example move logic
        return new String[] { getPosition() };
    }
}
