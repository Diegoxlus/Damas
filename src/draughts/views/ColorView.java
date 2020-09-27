package draughts.views;

import draughts.models.Color;
import utils.Console;

public class ColorView extends Console {
    Color color;

    public ColorView(Color color) {
        this.color = color;
    }

    public void show(){
        if (this.color.equals(Color.BLACK_COLOR)) {
            super.write(Console.ANSI_BLUE + Color.BLACK_COLOR.color + Console.ANSI_RESET);
        } else if (this.color.equals(Color.WHITE_COLOR)) {
             super.write(Console.ANSI_CYAN + Color.WHITE_COLOR.color + Console.ANSI_RESET);
        } else {
            super.write( Console.ANSI_BLACK + Color.NULL_COLOR.color + Console.ANSI_RESET);
        }
    }
}
