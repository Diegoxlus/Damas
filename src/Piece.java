public class Piece {
    enum Color{
        WHITE,
        BLACK
    }
    private Color color;

    public Piece(Color color){
        this.color=color;
    }

    public Color getColor() {
        return color;
    }
}
