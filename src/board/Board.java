package board;

import pieces.*;
import utils.Position;

/**
 * Represents the chess board.
 */
public class Board {
    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        initializeBoard();
    }

    /**
     * Initializes the chess board with the starting positions of pieces.
     */
    public void initializeBoard() {
        // Set up black pieces
        board[0][0] = new Rook("black", "A8");
        board[0][1] = new Knight("black", "B8");
        board[0][2] = new Bishop("black", "C8");
        board[0][3] = new Queen("black", "D8");
        board[0][4] = new King("black", "E8");
        board[0][5] = new Bishop("black", "F8");
        board[0][6] = new Knight("black", "G8");
        board[0][7] = new Rook("black", "H8");

        // Black pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("black", getPosition(i, 1));
        }

        // Set up white pieces
        board[7][0] = new Rook("white", "A1");
        board[7][1] = new Knight("white", "B1");
        board[7][2] = new Bishop("white", "C1");
        board[7][3] = new Queen("white", "D1");
        board[7][4] = new King("white", "E1");
        board[7][5] = new Bishop("white", "F1");
        board[7][6] = new Knight("white", "G1");
        board[7][7] = new Rook("white", "H1");

        // White pawns
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn("white", getPosition(i, 6));
        }
    }

    /**
     * Moves a piece from one position to another.
     * @param from The position of the piece to be moved.
     * @param to The position where the piece will be moved.
     */
    public void movePiece(Position from, Position to) {
        Piece piece = board[from.getRow()][from.getColumn()];  // Get the piece from the "from" position

        if (piece == null) {
            System.out.println("No piece at " + from.toString());
        } else {
            board[to.getRow()][to.getColumn()] = piece;  // Move the piece to the "to" position
            board[from.getRow()][from.getColumn()] = null;  // Remove the piece from the "from" position
        }
    }

    /**
     * Helper method to get the position as a string.
     */
    private String getPosition(int column, int row) {
        return "" + (char) ('A' + column) + (8 - row);
    }

    /**
     * Displays the current state of the board.
     */
    public void display() {
        System.out.println("  A  B  C  D  E  F  G  H");
        for (int row = 0; row < 8; row++) {
            System.out.print(8 - row + " ");
            for (int col = 0; col < 8; col++) {
                if (board[row][col] == null) {
                    System.out.print("## ");
                } else {
                    String pieceDisplay = board[row][col].getColor().charAt(0) + 
                                          board[row][col].getClass().getSimpleName().substring(0, 1);
                    System.out.print(pieceDisplay + " ");
                }
            }
            System.out.println(8 - row); // Right-side number coordinates
        }
        System.out.println("  A  B  C  D  E  F  G  H");
    }
}
