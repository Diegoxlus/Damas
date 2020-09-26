package draughts;

enum Message {

    NAME_PLAYERS("Enter the name of player: "),
    TURN("Player: "),
    ENTER_COORDINATE_TO_REMOVE("Enter the origin coordinate:"),
    ENTER_COORDINATE_TO_PUT("Enter the target coordinate:"),
    RESUME("Do you want to continue? ");

    private String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

}


