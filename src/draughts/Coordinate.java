package draughts;

import utils.ClosedInterval;
import utils.Console;

public class Coordinate {

    static final ClosedInterval LIMITS = new ClosedInterval(0, CheckerBoard.WIDTH);

    private int row;
    private int column;
    static final String ROW = "Row: ";
    static final String COLUMN = "Column: ";

    protected Coordinate() {
    }

    protected Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Coordinate getDiference(Coordinate coordinate) {
        return new Coordinate(this.row - coordinate.row, this.column - coordinate.column);
    }

    public Coordinate getIntermediate(Coordinate coordinate) {
        return new Coordinate((this.row + coordinate.getRow()) / 2, (this.column + coordinate.getColumn()) / 2);
    }

    public void read(String message) {
        assert message != null;
        Console console = Console.instance();
        boolean error;
        do {
            console.writeln(message);
            this.row = console.readInt(Coordinate.ROW);
            this.column = console.readInt(Coordinate.COLUMN);
            error = !LIMITS.isIncluded(this.row) || !LIMITS.isIncluded(this.column);
            if (error) {
                Error.WRONG_COORDINATES.writeln();
            }
        } while (error);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

}
