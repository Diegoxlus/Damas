package draughts.models;

public class Player {
    private String name;
    private Color color;
    private CheckerBoard checkerBoard;

    public Player(Color color, CheckerBoard checkerBoard) {
        this.color = color;
        this.checkerBoard = checkerBoard;
        this.name = "";
    }

    public Action isJumpOrMovement(Coordinate originCoordinate, Coordinate targetCoordinate) {
        Coordinate diference = originCoordinate.getDiference(targetCoordinate);
        Piece originPiece = this.checkerBoard.pieces[originCoordinate.getRow()][originCoordinate.getColumn()];

        if (originPiece.checkValidJumpInColumn(diference)) {
            return Action.JUMP;
        } else if (originPiece.checkValidMovementInColumn(diference)) {
            return Action.MOVEMENT;
        } else {
            return Action.NULL_ACTION;
        }
    }

    public Error checkTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
        if (!this.checkValidMovement(originCoordinate, targetCoordinate)) {
            return Error.WRONG_COORDINATES;
        } else {
            return Error.NULL_ERROR;
        }
    }

    private boolean checkValidMovement(Coordinate originCoordinate, Coordinate targetCoordinate) {
        Coordinate diference = originCoordinate.getDiference(targetCoordinate);
        Color color = this.color;
        Piece originPiece = this.checkerBoard.pieces[originCoordinate.getRow()][originCoordinate.getColumn()];
        return originPiece.checkValidMovementInRow(diference) &&
                ((originPiece.checkValidMovementInColumn(diference) &&
                        this.checkIsNullPieceInCheckboard(targetCoordinate, Color.NULL_COLOR)) ||
                        (originPiece.checkValidJumpInColumn(diference) &&
                                this.checkIsNullPieceInCheckboard(originCoordinate.getIntermediate(targetCoordinate), Color.enemyColor(color))));
    }

    private boolean checkIsNullPieceInCheckboard(Coordinate coordinate, Color color) {
        return this.checkerBoard.pieces[coordinate.getRow()][coordinate.getColumn()].getColor() == color;
    }


    public Error checkMoveOriginCoordinateError(Coordinate originCoordinate) {
        Error error = Error.NULL_ERROR;
        if (!this.checkerBoard.isOccupied(originCoordinate, this.color)) {
            error = Error.NOT_OWNER;
        }
        return error;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }
}
