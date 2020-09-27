package draughts.views;

import draughts.models.Coordinate;
import draughts.models.Error;
import draughts.models.Player;
import utils.Console;


public class PlayerView {
    protected Player player;

    public PlayerView(Player player) {
        this.player = player;
    }


    Error checkTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
        return this.player.checkTargetCoordinateError(originCoordinate, targetCoordinate);
    }

    Error checkMoveOriginCoordinateError(Coordinate originCoordinate) {
        return this.player.checkMoveOriginCoordinateError(originCoordinate);
    }

    public void readAndSetName() {
        this.player.setName(new Console().readString(MessageView.NAME_PLAYERS.getMessage()));
    }
}
