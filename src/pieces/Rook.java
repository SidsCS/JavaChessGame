package pieces;

/**
 * Class representing a Rook chess piece.
 */
public class Rook extends Piece {

    public Rook(String color, String position) {
        super(color, position);
    }

    @Override
    public String[] possibleMoves() {
        // Return the position using the getter method from the parent class
        return new String[] { getPosition() };
    }
}

