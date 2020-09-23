package draughts;

import draughts.Color;

public abstract class Piece {

    private Color color;

    public Piece(Color color){
        this.color=color;
    }

    public Color getColor() {
        return color;
    }

    public String getColorPiece(){
        return color.toString();
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
