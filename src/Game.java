public class Game {
    public static void main(String[] args) {
        CheckerBoard cb = new CheckerBoard();
        Turn turn = new Turn(cb);
        cb.showCheckerBoard();

    }
}
