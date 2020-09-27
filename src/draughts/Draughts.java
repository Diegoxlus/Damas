package draughts;

import draughts.models.Game;
import draughts.views.View;

public class Draughts {
    private Game game;

    private View view;

    Draughts() {
        this.game = new Game();
        this.view = new View(this.game);
    }

    private void play() {
        this.view.interact();
    }

    public static void main(String[] args) {
        new Draughts().play();
    }
}
