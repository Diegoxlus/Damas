package draughts;

public class Color {

    public enum ChooseColor{
        WHITE,
        BLACK,
        NULL
    }

    private ChooseColor color;

    public Color(ChooseColor color){
        this.color=color;
    }

    public Color(int index){
        this(ChooseColor.values()[index]);
    }

    @Override
    public String toString() {
        if(this.color == ChooseColor.BLACK){
            return " X ";
        } else if (this.color == ChooseColor.WHITE) {
            return " O ";
        } else if (this.color == ChooseColor.NULL) {
            return " - ";
        } else{
            return Error.WRONG_COLOR.toString();
        }
    }


}
