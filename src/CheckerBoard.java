import java.util.ArrayList;
import java.util.List;


public class CheckerBoard {
    public static final int  WIDTH = 8;
    public static final int  HEIGHT = 8;

    public Piece[][] squares;
    private boolean visible;

    public CheckerBoard() {
        this.squares = new Piece[WIDTH][HEIGHT];
        this.putBlackPiecesInCheckerBoard();
        this.putWhitePiecesInCheckerBoard();
        this.visible = false;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void putWhitePiecesInCheckerBoard() {
        for (int i = 0; i <HEIGHT/2; i++ ){
            for (int j = 0; j<WIDTH; j++){
                if((i+j)%2!=0){
                    this.squares[i][j] = new Men(new Color(Color.ChooseColor.WHITE));
                }
            }
        }
    }

    public void putBlackPiecesInCheckerBoard() {
        for (int i = HEIGHT/2; i <HEIGHT; i++ ){
            for (int j = 0; j < WIDTH; j++){
                if((i+j)%2!=0){
                    this.squares[i][j] =  new Men(new Color(Color.ChooseColor.BLACK));
                }
            }
        }
    }
}
