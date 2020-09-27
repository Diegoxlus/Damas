package draughts.views;

import draughts.models.Error;
import utils.Console;

public class ErrorView extends Console {
    private Error error;

    ErrorView(Error error) {
        this.error = error;
    }

    void writeln() {
        super.writeln(error.name());
    }
}
