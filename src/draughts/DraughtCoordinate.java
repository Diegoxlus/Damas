package draughts;

import utils.ClosedInterval;
import utils.Coordinate;

public class DraughtCoordinate extends Coordinate {

    static final ClosedInterval LIMITS = new ClosedInterval(0, CheckerBoard.WIDTH);

    private int row;
    private int column;

    public DraughtCoordinate(){
        super();
    }

    public DraughtCoordinate(int row, int column){
        super(row,column);
    }

    public void read(String message) {
        assert message != null;

        boolean error;
        do {
            super.read(message);
            error = !LIMITS.isIncluded(this.row) || !LIMITS.isIncluded(this.column);
            if (error) {
                Error.WRONG_COORDINATES.writeln();
            }
        } while (error);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
