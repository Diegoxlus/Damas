package draughts.views;

import draughts.models.Color;
import draughts.models.Turn;
import utils.Console;

public class TurnView {
    protected Turn turn;

    public TurnView(Turn turn) {
        this.turn = turn;
    }

    public void show() {
        Color color = this.turn.getColorPlayer();
        new Console().write(MessageView.TURN.getMessage()+ this.turn.getNamePlayer()+" -->");
        new ColorView(color).show();
        Console.instance().writeln("");
    }
}
