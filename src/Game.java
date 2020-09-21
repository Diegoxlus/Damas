public class Game {

    private CheckerBoard checkerBoard;
    private Turn turn;

    void play(){
        this.checkerBoard=new CheckerBoard();
        this.turn=new Turn(this.checkerBoard);
        checkerBoard.show();
    }

    public static void main(String[] args) {
        new Game().play();
    }
}
