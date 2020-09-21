import utils.Console;
import utils.LimitedIntDialog;
import utils.Message;

public class Turn {
    static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int active;

    Turn(CheckerBoard checkerBoard){
        //int numberPlayers = new LimitedIntDialog(Turn.NUMBER_PLAYERS).read(Message.NUMBER_PLAYERS);
        this.players = new Player[Turn.NUMBER_PLAYERS];
        for (int i = 0; i< Turn.NUMBER_PLAYERS; i++){
            String namePlayer = new Console().readString(Message.NAME_PLAYERS);
            this.players[i] = this.createPlayer(namePlayer, checkerBoard, i);
        }
        this.active = NUMBER_PLAYERS - (NUMBER_PLAYERS-1);
        checkerBoard.setVisible(true);
    }
    private Player createPlayer(String name, CheckerBoard checkerBoard, int indexColor){
        return  new Player(name,new Color(indexColor), checkerBoard);
    }

    void play(){
        this.active = (this.active+1) % NUMBER_PLAYERS;
        this.getPlayer().play();
    }

    private Player getPlayer() { return this.players[this.active];}
}
