package draughts;

public abstract class Piece {

    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    abstract boolean checkValidMovementInColumn(Coordinate diference);

    abstract boolean checkValidJumpInColumn(Coordinate diference);

    abstract boolean checkValidMovementInRow(Coordinate diference);

}
