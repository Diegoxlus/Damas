package draughts;

import utils.Console;

public enum Color {

    WHITE_COLOR(" O "),
    BLACK_COLOR(" X "),
    NULL_COLOR(" - ");

    private String color;

    private Color(String color){
        this.color=color;
    }

    static Color get(int index){
        return Color.values()[index];
    }

    void write() {
        Console.instance().write(this.color);
    }

}
