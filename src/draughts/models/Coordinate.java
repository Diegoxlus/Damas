package draughts.models;

import utils.ClosedInterval;

public class Coordinate {

    static ClosedInterval LIMITS = new ClosedInterval(0, CheckerBoard.WIDTH);

    private int row;
    private int column;
    static final String ROW = "Row: ";
    static final String COLUMN = "Column: ";

    public Coordinate() {
    }

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Coordinate getDiference(Coordinate coordinate) {
        return new Coordinate(this.row - coordinate.row, this.column - coordinate.column);
    }

    public Coordinate getIntermediate(Coordinate coordinate) {
        return new Coordinate((this.row + coordinate.getRow()) / 2, (this.column + coordinate.getColumn()) / 2);
    }

    public boolean validCoordinate() {
        return LIMITS.isIncluded(this.row) && LIMITS.isIncluded(this.column);
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

}
