package draughts;

import draughts.Color;

public class Men extends Piece {

    public Men(Color color){
        super(color);
    }

    boolean checkValidMovementInColumn(Coordinate diference){
        return diference.getColumn()==1 || diference.getColumn()==-1;
    }

    boolean checkValidJumpInColumn(Coordinate diference){
        return diference.getColumn()==2 || diference.getColumn()==-2;
    }

    boolean checkValidMovementInRow(Coordinate diference){
        if(this.getColor()==Color.BLACK_COLOR &&
                (diference.getRow()!=-1 || diference.getRow()!=-2)){
            return true;
        } else return this.getColor() == Color.WHITE_COLOR &&
                (diference.getRow() != 1 || diference.getRow() != 2);
    }

}
