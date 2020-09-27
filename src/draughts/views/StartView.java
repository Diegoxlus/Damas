package draughts.views;

import draughts.models.Game;

public class StartView {

    Game game;

    public StartView(Game game) {
        this.game = game;
    }

    public void interact() {
        MessageView.START_GAME.writeln();
        PlayerView playerView = new PlayerView(this.game.getPlayerInTurn());
        PlayerView otherPlayerView = new PlayerView(this.game.getOtherPlayer());
        playerView.readAndSetName();
        otherPlayerView.readAndSetName();
        new BoardView(this.game.getCheckerBoard()).show();
    }
}
