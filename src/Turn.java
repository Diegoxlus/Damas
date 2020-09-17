import utils.LimitedIntDialog;
import utils.Message;

public class Turn {
    static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int active;

    Turn(CheckerBoard checkerBoard){
        int numberPlayers = new LimitedIntDialog(Turn.NUMBER_PLAYERS).read(Message.NUMBER_PLAYERS);
    }
}
