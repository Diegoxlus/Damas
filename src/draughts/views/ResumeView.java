package draughts.views;

import draughts.models.Game;
import utils.YesNoDialog;

public class ResumeView {
    Game game;

    public ResumeView(Game game) {
        this.game = game;
    }

    public boolean interact() {
        MessageView.RESUME.writeln();
        boolean newGame = new YesNoDialog().read();
        if (newGame) {
            this.game.newGame();
        }
        return newGame;
    }
}
