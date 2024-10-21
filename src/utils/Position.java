package utils;

/**
 * Class representing a position on the chess board.
 */
public class Position {
    private int row;
    private int column;

    // Constructor
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Getters
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    // Setters
    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    // Helper method to convert a string-based position like "A8" into a Position object
    public static Position fromString(String pos) {
        char columnChar = pos.charAt(0);  // 'A' to 'H'
        int column = columnChar - 'A';    // Convert column char ('A') to integer (0 for 'A', 1 for 'B', etc.)
        int row = 8 - Character.getNumericValue(pos.charAt(1));  // Convert row char ('8') to 0-based row index
        return new Position(row, column);
    }

    // Helper method to convert a Position object back into a string like "A8"
    public String toString() {
        char columnChar = (char) ('A' + column);  // Convert integer column back to letter
        int rowChar = 8 - row;  // Convert 0-based row index back to 1-based row
        return "" + columnChar + rowChar;
    }
}
