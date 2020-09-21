import java.util.ArrayList;
import java.util.List;


public class CheckerBoard {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";


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

    public void putBlackPiecesInCheckerBoard() {
        for (int i = 0; i <HEIGHT/2-1; i++ ){
            for (int j = 0; j<WIDTH; j++){
                if((i+j)%2!=0){
                    this.squares[i][j] = new Men(new Color(Color.ChooseColor.BLACK));
                }
            }
        }
    }

    public void putWhitePiecesInCheckerBoard() {
        for (int i = HEIGHT/2+1; i <HEIGHT; i++ ){
            for (int j = 0; j < WIDTH; j++){
                if((i+j)%2!=0){
                    this.squares[i][j] =  new Men(new Color(Color.ChooseColor.WHITE));
                }
            }
        }
    }

    public void showCheckerBoard(){
        System.out.print(ANSI_GREEN+"    0  1  2  3  4  5  6  7" +ANSI_RESET);
        for (int i = 0; i< HEIGHT; i++){
            System.out.println("\n");
            for (int j = 0; j<WIDTH;j++){
                if(j==0){
                    System.out.print(ANSI_GREEN+i+"  "+ANSI_RESET);
                }
                if(this.squares[i][j]==null){
                    System.out.print(" - ");
                }
                else System.out.print(this.squares[i][j].getColor().toString());
            }

        }
    }


}
