package draughts;

import utils.Console;

public enum Color {

    WHITE_COLOR(" O "),
    BLACK_COLOR(" X "),
    NULL_COLOR(" - ");

    private String color;

    private Color(String color) {
        this.color = color;
    }

    static Color get(int index) {
        return Color.values()[index];
    }

    static Color enemyColor(Color color) {
        if (color == Color.WHITE_COLOR) {
            return Color.BLACK_COLOR;
        } else if (color == Color.BLACK_COLOR) {
            return Color.WHITE_COLOR;
        } else {
            return Color.NULL_COLOR;
        }
    }

    @Override
    public String toString() {
        if (this.color.equals(Color.BLACK_COLOR.color)) {
            return Console.ANSI_BLUE + Color.BLACK_COLOR.color + Console.ANSI_RESET;
        } else if (this.color.equals(Color.WHITE_COLOR.color)) {
            return Console.ANSI_CYAN + Color.WHITE_COLOR.color + Console.ANSI_RESET;
        } else {
            return Console.ANSI_BLACK + Color.NULL_COLOR.color + Console.ANSI_RESET;
        }
    }

    public boolean equals(Color color) {
        return this.color.equals(color.color);
    }
}
