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
            this.players[i] = this.createPlayer(i,checkerBoard);
        }
        this.active = NUMBER_PLAYERS - (NUMBER_PLAYERS-1);
    }
    private Player createPlayer(int indexColor, CheckerBoard checkerBoard){
        Player player = new Player(new Color(indexColor), checkerBoard);
        player.readAndSetName();
        return player;
    }

    void play(){
        this.active = (this.active+1) % NUMBER_PLAYERS;
        this.getPlayer().play();
    }

    private Player getPlayer() { return this.players[this.active];}
}
