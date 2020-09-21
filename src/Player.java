import utils.Console;
import utils.Message;

public class Player {
    private String name;
    private Color color;
    private CheckerBoard checkerBoard;

    public Player(Color color, CheckerBoard checkerBoard){
        this.color=color;
        this.checkerBoard = checkerBoard;
        this.name= "";
    }

    void play(){

    }

    public void readAndSetName(){
        this.name = new Console().readString(Message.NAME_PLAYERS);
    }

}
