package draughts;

import utils.Console;

enum Error {

    NOT_OWNER("There is not a token of yours"),
    WRONG_COORDINATES("The coordinates are wrong"),
    NULL_ERROR;

    private String message;

    Error() {
    }

    Error(String message) {
        this.message = message;
    }

    void writeln() {
        if (this != Error.NULL_ERROR) {
            new Console().writeln(this.message);
        }
    }

    @Override
    public String toString() {
        return this.message;
    }
}
