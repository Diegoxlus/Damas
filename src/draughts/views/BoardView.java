package draughts.views;

import draughts.models.CheckerBoard;
import utils.Console;

import static draughts.models.CheckerBoard.HEIGHT;
import static draughts.models.CheckerBoard.WIDTH;

public class BoardView {
    CheckerBoard checkerBoard;

    public BoardView(CheckerBoard checkerBoard) {
        this.checkerBoard = checkerBoard;
    }

    public void show() {
        Console.instance().write(Console.ANSI_GREEN + "    0  1  2  3  4  5  6  7" + Console.ANSI_RESET);
        for (int i = 0; i < HEIGHT; i++) {
            Console.instance().writeln("");
            Console.instance().write(Console.ANSI_GREEN + i + "  " + Console.ANSI_RESET);
            for (int j = 0; j < WIDTH; j++) {
                new ColorView(this.checkerBoard.pieces[i][j].getColor()).show();
            }
        }
        Console.instance().writeln("");
    }
}
