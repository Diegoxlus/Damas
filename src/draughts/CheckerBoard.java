package draughts;

import utils.Console;

public class CheckerBoard {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    public Piece[][] pieces;

    public CheckerBoard() {
        this.pieces = new Piece[WIDTH][HEIGHT];
        this.putPieces();
    }

    private void putPieces() {
        this.fillNullPieces();
        for (int i = 0; i <HEIGHT; i++ ){
            for (int j = 0; j<WIDTH; j++){
                this.putBlackOrWhitePiece(i,j);
            }
        }
    }

    private void fillNullPieces(){
        for (int i = 0; i<HEIGHT;i++){
            for (int j= 0; j<WIDTH;j++){
                if(isEmptySquare(i,j) || is4or5row(i)){
                    this.pieces[i][j] = new Men(Color.NULL_COLOR);
                }
            }
        }
    }

    private void putBlackOrWhitePiece(int i,int j){
        if(!this.isEmptySquare(i,j) && !this.is4or5row(i)){
            if(i<HEIGHT/2-1){
                this.pieces[i][j] = new Men(Color.BLACK_COLOR);
            } else if(i>HEIGHT/2){
                this.pieces[i][j] = new Men(Color.WHITE_COLOR);
            } else{
                new Console().writeError(Error.WRONG_COORDINATES.toString());
            }
        }
    }

    private boolean isEmptySquare(int i , int j){
        return (i+j)%2==0;
    }

    private boolean is4or5row(int row){
        return row>2&&row<5;
    }

    boolean isOccupied(Coordinate coordinate,Color color ) {
        return this.getColorPiece(coordinate).equals(color);
    }

    public void show(){
        System.out.print(ANSI_GREEN+"    0  1  2  3  4  5  6  7" +ANSI_RESET);
        for (int i = 0; i< HEIGHT; i++){
            Console.instance().writeln("");
            Console.instance().write(ANSI_GREEN+i+"  "+ANSI_RESET);
            for (int j = 0; j<WIDTH;j++){
                Console.instance().write(this.pieces[i][j].getColor().toString());
            }
        }
        Console.instance().writeln("");
    }

    private Color getColorPiece(Coordinate coordinate){
        return this.pieces[coordinate.getRow()][coordinate.getColumn()].getColor();
    }

    private void changeCoordinateColor(Coordinate coordinate, Color color){
        this.pieces[coordinate.getRow()][coordinate.getColumn()].setColor(color);
    }

    void move(Coordinate origin, Coordinate target){
        Color originColor = this.getColorPiece(origin);
        this.changeCoordinateColor(origin,Color.NULL_COLOR);
        this.changeCoordinateColor(target,originColor);
    }

    void jump(Coordinate origin, Coordinate target){
        Coordinate intermediate = origin.getIntermediate(target);
        Color originColor = this.getColorPiece(origin);
        this.changeCoordinateColor(origin,Color.NULL_COLOR);
        this.changeCoordinateColor(intermediate,Color.NULL_COLOR);
        this.changeCoordinateColor(target,originColor);
    }

    boolean isDraughts(){
        int countWhites=0;
        int countBlacks=0;
        for(int i=0;i<HEIGHT;i++){
            for(int j=0;i<WIDTH;i++){
                if(this.pieces[i][j].getColor()==Color.WHITE_COLOR){
                    countWhites++;
                }
                if(this.pieces[i][j].getColor()==Color.BLACK_COLOR){
                    countBlacks++;
                }
            }
        }
        return countWhites == 0 || countBlacks == 0;
    }


}
