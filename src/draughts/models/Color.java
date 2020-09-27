package draughts.models;

import utils.Console;

public enum Color {

    WHITE_COLOR(" O "),
    BLACK_COLOR(" X "),
    NULL_COLOR(" - ");

    public String color;

    Color(String color) {
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

    public boolean equals(Color color) {
        return this.color.equals(color.color);
    }
}
