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
}
