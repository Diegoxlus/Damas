package draughts;

public enum Action {

    JUMP("JUMP"),
    MOVEMENT("MOVEMENT"),
    NULL_ACTION("NULL");

    private String action;

    private Action(String action){
        this.action=action;
    }

    static Action get(int index){
        return Action.values()[index];
    }
}
