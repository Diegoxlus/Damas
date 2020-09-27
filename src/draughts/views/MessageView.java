package draughts.views;

import utils.Console;

enum MessageView {

    NAME_PLAYERS("Enter the name of player: "),
    TURN("Player: "),
    ENTER_COORDINATE_TO_REMOVE("Enter the origin coordinate:"),
    ENTER_COORDINATE_TO_PUT("Enter the target coordinate:"),
    RESUME("Do you want to continue? "),
    START_GAME("START........");

    private String message;


    private Console console;

    MessageView(String message) {
        this.console = new Console();
        this.message = message;
    }

    String getMessage() {
        return this.message;
    }

    void writeln() {
        this.console.writeln(this.message);
    }

}


