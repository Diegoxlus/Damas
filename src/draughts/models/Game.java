package draughts.models;

public class Game {

    private CheckerBoard checkerBoard;
    private Player[] players;
    private Turn turn;

    public Game() {
        this.newGame();
    }

    public void newGame() {
        this.checkerBoard = new CheckerBoard();
        this.createPlayers();
        this.turn = new Turn(players);
    }

    private void createPlayers() {
        this.players = new Player[Turn.NUM_PLAYERS];
        for (int i = 0; i < Turn.NUM_PLAYERS; i++) {
            this.players[i] = new Player(Color.get(i), checkerBoard);
        }
    }

    public CheckerBoard getCheckerBoard() {
        return checkerBoard;
    }

    public Player getPlayerInTurn() {
        return this.turn.getPlayer();
    }

    public Player getOtherPlayer() {
        return this.turn.getOtherPlayer();
    }

    public boolean isDraughts() {
        return this.checkerBoard.isDraughts();
    }

    public Action isJumpOrMovement(Coordinate originCoordinate, Coordinate targetCoordinate) {
        return this.getPlayerInTurn().isJumpOrMovement(originCoordinate, targetCoordinate);
    }

    public void move(Coordinate originCoordinate, Coordinate targetCoordinate) {
        this.checkerBoard.move(originCoordinate, targetCoordinate);
    }

    public void jump(Coordinate originCoordinate, Coordinate targetCoordinate) {
        this.checkerBoard.jump(originCoordinate, targetCoordinate);
    }

    public Turn getTurn() {
        return turn;
    }

    public void changeTurn() {
        this.turn.change();
    }
}
