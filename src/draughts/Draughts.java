package draughts;

import utils.YesNoDialog;

public class Draughts {

    private CheckerBoard checkerBoard;
    private Turn turn;

    void play(){
        do{
            this.checkerBoard=new CheckerBoard();
            this.turn=new Turn(this.checkerBoard);
            checkerBoard.show();
            do{

            } while()
        } while(isResumedGame());

    }

    private boolean isResumedGame(){
        return new YesNoDialog().read(Message.RESUME.toString());
    }

    public static void main(String[] args) {
        new Draughts().play();
    }
}
