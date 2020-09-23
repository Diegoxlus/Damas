package draughts;

import utils.Console;

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
        Error errorOrigin;
        Error errorTarget;
        Coordinate originCoordinate;
        Coordinate targetCordinate;
        do{
            originCoordinate = this.getCoordinateOriginToRemove();
            errorOrigin = this.checkMoveOriginCoordinateError(originCoordinate);
            targetCordinate = this.getCordinateTargetToMove();
            errorTarget = this.checkTargetCoordinateError(originCoordinate,targetCordinate);
        } while (errorOrigin!= Error.NULL_ERROR && errorTarget!=Error.NULL_ERROR);
        if(this.isJumpOrMovement(originCoordinate,targetCordinate)==Action.JUMP){
            this.checkerBoard.jump(originCoordinate,targetCordinate);
        } else{
            this.checkerBoard.move(originCoordinate,targetCordinate);
        }
    }

    private Action isJumpOrMovement(Coordinate originCoordinate, Coordinate targetCoordinate){
        Coordinate diference = originCoordinate.getDiference(targetCoordinate);
        if(this.checkValidJumpInColumn(diference)){
            return Action.JUMP;
        } else if(this.checkValidMovementInColumn(diference)){
            return Action.MOVEMENT;
        } else {
            return Action.NULL_ACTION;
        }
    }

    private Error checkTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
        if(!this.checkValidMovement(originCoordinate,targetCoordinate)) {
            return Error.WRONG_COORDINATES;
        } else {
            return Error.NULL_ERROR;
        }
    }

    private boolean checkValidMovement(Coordinate originCoordinate, Coordinate targetCordinate){
        Coordinate diference = originCoordinate.getDiference(targetCordinate);
        Color color = this.color;
        return this.checkValidMovementInRow(diference, color) &&
                ( ( this.checkValidMovementInColumn(diference) &&
                this.checkIsNullPieceInCheckboard(targetCordinate, Color.NULL_COLOR) ) ||
                ( this.checkValidJumpInColumn(diference) &&
                this.checkIsNullPieceInCheckboard(originCoordinate.getIntermediate(targetCordinate), Color.enemyColor(color)) ) );
    }

    private boolean checkIsNullPieceInCheckboard(Coordinate coordinate, Color color){
        return this.checkerBoard.pieces[coordinate.getRow()][coordinate.getColumn()].getColor()==color;
    }

    private boolean checkValidMovementInColumn(Coordinate diference){
        return diference.getColumn()==1 || diference.getColumn()==-1;
    }

    private boolean checkValidJumpInColumn(Coordinate diference){
        return diference.getColumn()==2 || diference.getColumn()==-2;
    }

    private boolean checkValidMovementInRow(Coordinate diference, Color color){
        if(color==Color.BLACK_COLOR && (diference.getRow()!=-1 || diference.getRow()!=-2)){
            return true;
        } else return color == Color.WHITE_COLOR && (diference.getRow() != 1 || diference.getRow() != 2);
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
        Coordinate coordinate = new Coordinate();
        coordinate.read(message.toString());
        return coordinate;
    }

}
