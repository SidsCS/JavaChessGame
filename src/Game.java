import board.Board;
import utils.Position;
import java.util.Scanner;

/**
 * Main class for running the chess game.
 */
public class Game {
    private Board board;
    private boolean isWhiteTurn;  // True if it's white's turn, false if it's black's turn
    private boolean drawOffered;  // Track if a draw has been offered

    public Game() {
        board = new Board();
        isWhiteTurn = true;  // Start with white's turn
        drawOffered = false;  // No draw offer initially
    }

    public void start() {
        while (true) {
            displayGame();  // Display the game (title + board + aesthetic touches)
            promptMove();  // Prompt the current player to make a move or take action
            isWhiteTurn = !isWhiteTurn;  // Switch turns
        }
    }

    /**
     * Displays the chess game, including the title, a framed board, and separators.
     */
    public void displayGame() {
        String longestText = "Player 2 (Black), it's your turn to move a black piece.";
        int separatorLength = longestText.length();

        System.out.println(centerText(repeatChar('=', separatorLength), separatorLength));  // Upper border line
        System.out.println(centerText("Chess Game", separatorLength));  // Centered title
        System.out.println(centerText(repeatChar('=', separatorLength), separatorLength));  // Lower border line

        System.out.println();  // Extra line for spacing

        // Frame around the board
        System.out.println(repeatChar('-', separatorLength));
        board.display();  // Display the board (this will already handle the board display)
        System.out.println(repeatChar('-', separatorLength));

        System.out.println();  // Extra line for spacing
    }

    /**
     * Prompts the player for a move or an action (surrender, draw offer).
     */
    public void promptMove() {
        Scanner scanner = new Scanner(System.in);

        // Indicate whose turn it is
        String currentPlayer = isWhiteTurn ? "Player 1 (White)" : "Player 2 (Black)";
        String longestText = currentPlayer + ", it's your turn to move a " + (isWhiteTurn ? "white" : "black") + " piece.";
        int separatorLength = longestText.length();

        System.out.println(currentPlayer + ", it's your turn to move a " + (isWhiteTurn ? "white" : "black") + " piece.");
        System.out.println(repeatChar('-', separatorLength));

        // Check if a draw has been offered
        if (drawOffered) {
            System.out.println(currentPlayer + " has offered a draw. Type '2' to accept the draw, or make your move:");
        } else {
            System.out.println("Enter your move (e.g., " + (isWhiteTurn ? "E2 E4" : "E7 E5") + 
                               ") or type '1' to surrender or '2' to offer a draw:");
        }

        System.out.println(repeatChar('-', separatorLength));

        String input = scanner.nextLine();

        if (input.equals("1")) {
            surrender();
        } else if (input.equals("2")) {
            offerDraw();
        } else if (validateMoveFormat(input)) {
            String[] positions = input.split(" ");
            String from = positions[0];  // E.g., "E2" or "E7"
            String to = positions[1];    // E.g., "E4" or "E5"

            // Move the piece from the "from" position to the "to" position
            board.movePiece(Position.fromString(from), Position.fromString(to));

            // Display move confirmation
            System.out.println(currentPlayer + " moved from " + from + " to " + to + ".");
            drawOffered = false;  // Reset draw offer after any move
        } else {
            System.out.println("Invalid move format! Please use the format [FROM] [TO], e.g., " + 
                               (isWhiteTurn ? "E2 E4" : "E7 E5") + ".");
        }
    }

    /**
     * Handles a player surrender.
     */
    public void surrender() {
        System.out.println((isWhiteTurn ? "Player 1 (White)" : "Player 2 (Black)") + " has surrendered!");
        System.out.println((isWhiteTurn ? "Player 2 (Black)" : "Player 1 (White)") + " wins the game!");
        System.exit(0);  // End the game
    }

    /**
     * Handles a draw offer.
     */
    public void offerDraw() {
        // If a draw has already been offered, the other player must accept it
        if (drawOffered) {
            System.out.println("The draw has been accepted. The game ends in a draw.");
            System.exit(0);  // End the game
        } else {
            System.out.println((isWhiteTurn ? "Player 1 (White)" : "Player 2 (Black)") + " has offered a draw.");
            drawOffered = true;  // Set the draw offer flag
        }
    }

    /**
     * Validates the move format (e.g., "E2 E4").
     */
    public boolean validateMoveFormat(String move) {
        // Check if the move is in the format "[FROM] [TO]" (like "E2 E4")
        return move.matches("^[A-H][1-8] [A-H][1-8]$");
    }

    /**
     * Repeats a character for a specified length.
     * @param c The character to repeat.
     * @param length The length of the repeated string.
     * @return A string made of the repeated character.
     */
    public String repeatChar(char c, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * Helper method to center text.
     * @param text The text to center.
     * @param width The total width to center within.
     * @return The centered text with padding spaces.
     */
    public String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padding; i++) {
            sb.append(" ");
        }
        sb.append(text);
        return sb.toString();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
