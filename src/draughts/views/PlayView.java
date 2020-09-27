package draughts.views;

import draughts.models.Action;
import draughts.models.Coordinate;
import draughts.models.Error;
import draughts.models.Game;

public class PlayView {
    Game game;

    public PlayView(Game game) {
        this.game = game;
    }

    public boolean interact() {
        PlayerView playerView = new PlayerView(this.game.getPlayerInTurn());
        CoordinateView coordinateView = new CoordinateView();
        new TurnView(this.game.getTurn()).show();
        if (!this.game.isDraughts()) {
            Coordinate originCoordinate = coordinateView.read(MessageView.ENTER_COORDINATE_TO_REMOVE.getMessage());
            Coordinate targetCoordinate = coordinateView.read(MessageView.ENTER_COORDINATE_TO_PUT.getMessage());
            Error errorOrigin = playerView.checkMoveOriginCoordinateError(originCoordinate);
            Error errorTarget = playerView.checkTargetCoordinateError(originCoordinate, targetCoordinate);

            if (errorOrigin == Error.NULL_ERROR && errorTarget == Error.NULL_ERROR) {
                if (this.game.isJumpOrMovement(originCoordinate, targetCoordinate) == Action.MOVEMENT) {
                    this.game.move(originCoordinate, targetCoordinate);
                } else {
                    this.game.jump(originCoordinate, targetCoordinate);
                }
                new BoardView(this.game.getCheckerBoard()).show();
                this.game.changeTurn();
                return false;
            } else {
                new ErrorView(Error.WRONG_COORDINATES).writeln();
                return false;
            }
        }
        return true;
    }
}
