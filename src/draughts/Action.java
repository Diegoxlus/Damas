package draughts;

public enum Action {

    JUMP("JUMP"),
    MOVEMENT("MOVEMENT"),
    NULL_ACTION("NULL");

    private String action;

    private Action(String action) {
        this.action = action;
    }

}
