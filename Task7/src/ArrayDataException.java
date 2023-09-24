package Task7.src;

public class ArrayDataException extends Exception {

    private int row;
    private int col;

    public ArrayDataException(String message, int row, int col) {
        super(message);
        this.col = col;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
