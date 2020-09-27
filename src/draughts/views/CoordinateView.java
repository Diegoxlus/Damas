package draughts.views;

import draughts.models.Coordinate;
import draughts.models.Error;
import utils.Console;

public class CoordinateView {

    public Coordinate read(String message) {
        assert message != null;
        Console console = Console.instance();
        Coordinate coordinate;
        boolean valid;
        do {
            console.writeln(message);
            int row = console.readInt("Row: ");
            int column = console.readInt("Col: ");
            coordinate = new Coordinate(row, column);
            valid = coordinate.validCoordinate();
            if (!valid) {
                Error.WRONG_COORDINATES.writeln();
            }
        } while (!valid);
        return coordinate;
    }
}
