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

    public void moveMen(int x, int y,int xf, int yf){
        //Comprobar que no se salga fuera del tablero
        //Comprobar que la posicion es valida( 1 pos a la derecha o izquierda, 1 pos hacia delante)
        //Comprobar que no hay un men enemigo para comer
        //Comprobar que no se mueve hacia atras
    }

    public void jumpMen(int xo, int yo, int xf, int yf){
        //Comprobar que no se salga fuera del tablero
        //Comprobar que la posicion es valida( 2 pos a la derecha o izquierda, 2 pos hacia delante)
        //Comprobar que hay un men enemigo para comer.
        //Comprobar que no hay un men enemigo justo en la trayectoria para comer
        //Comprobar que no se mueve hacia atras
    }

    public void showCheckerBoard(){
        for (int i = 0; i< HEIGHT; i++){
            System.out.println("\n");
            for (int j = 0; j<WIDTH;j++){
                if(this.squares[i][j]==null){
                    System.out.print(" - ");
                }
                else System.out.print(this.squares[i][j].getColor().toString());
            }
        }
    }


}
