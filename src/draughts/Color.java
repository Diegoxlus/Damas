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

    void write() {
        Console.instance().write(this.color);
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
            return Color.BLACK_COLOR.color;
        } else if (this.color.equals(Color.WHITE_COLOR.color)) {
            return Color.WHITE_COLOR.color;
        } else {
            return Color.NULL_COLOR.color;
        }
    }

    public boolean equals(Color color) {
        return this.color.equals(color.color);
    }
}
