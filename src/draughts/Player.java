package draughts;

import utils.Console;
import utils.Coordinate;

public class Player {
    private String name;
    private Color color;
    private CheckerBoard checkerBoard;

    public Player(Color color, CheckerBoard checkerBoard){
        this.color=color;
        this.checkerBoard = checkerBoard;
        this.name= "";
    }

    void play(){

    }

    void move(){
        Error error;
        Coordinate originCoordinate;
        do{
            originCoordinate = this.getCoordinateOriginToRemove();
            error = this.checkMoveOriginCoordinateError(originCoordinate);
        } while (error!= Error.NULL_ERROR);
        Coordinate targetCordinate;
        do{
            targetCordinate = this.getCordinateTargetToMove();
            error = this.checkTargetCoordinateError(originCoordinate,targetCordinate);
        }
    }

    private Error checkTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCordinate) {
        
    }

    private Coordinate getCordinateTargetToMove() {
        return this.getCoordinate(Message.ENTER_COORDINATE_TO_PUT);
    }

    Error checkMoveOriginCoordinateError(Coordinate originCoordinate) {
        assert originCoordinate != null;
        Error error = Error.NULL_ERROR;
        if (!this.checkerBoard.isOccupied(originCoordinate, this.color)) {
            error = Error.NOT_OWNER;
        }
        return error;
    }

    public void readAndSetName(){
        this.name = new Console().readString(Message.NAME_PLAYERS.toString());
    }

    Coordinate getCoordinateOriginToRemove() {
        return this.getCoordinate(Message.ENTER_COORDINATE_TO_REMOVE);
    }

    private Coordinate getCoordinate(Message message){
        assert message != null;

        Coordinate coordinate = new DraughtCoordinate();
        coordinate.read(message.toString());
        return coordinate;
    }

}
