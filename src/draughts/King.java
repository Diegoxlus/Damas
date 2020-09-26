package draughts;

import draughts.Color;

public class King extends Piece {

    public King(Color color){
        super(color);
    }

    @Override
    boolean checkValidMovementInColumn(Coordinate diference) {
        return false;
    }

    @Override
    boolean checkValidJumpInColumn(Coordinate diference) {
        return false;
    }

    @Override
    boolean checkValidMovementInRow(Coordinate diference) {
        return false;
    }
}
