package draughts.models;

public class Turn {

    public static final int NUM_PLAYERS = 2;

    private int value;

    private Player[] players;

    public Turn(Player[] players) {
        this.value = 0;
        this.players = players;
    }

    void change() {
        this.value = this.getOtherValue();
    }

    Player getPlayer() {
        return this.players[this.value];
    }

    public String getNamePlayer() {
        return this.getPlayer().getName();
    }

    private int getOtherValue() {
        return (this.value + 1) % Turn.NUM_PLAYERS;
    }

    Player getOtherPlayer() {
        return this.players[this.getOtherValue()];
    }

    public Color getColorPlayer() {
        return this.getPlayer().getColor();
    }

}
