public class Color {

    enum ChooseColor{
        WHITE,
        BLACK
    }
    private ChooseColor color;

    public Color(ChooseColor color){
        this.color=color;
    }

    @Override
    public String toString() {
        if(this.color == ChooseColor.BLACK){
            return " X ";
        }
        else if(this.color == ChooseColor.WHITE){
            return " O ";
        }
        else return "-";
    }
}
