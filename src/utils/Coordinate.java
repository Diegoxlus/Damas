package utils;

import draughts.Color;

public class Coordinate {

    private int row;
    private int column;
    static final String ROW= "Row: ";
    static final String COLUMN="Column: ";

    protected Coordinate(){
    }

    protected Coordinate(int row, int column){
        this.row=row;
        this.column=column;
    }

    protected Direction getDirection(Coordinate coordinate){

    }

    public void read(String message) {
        Console console = Console.instance();
        console.write(message);
        this.row = console.readInt(Coordinate.ROW) - 1;
        this.column = console.readInt(Coordinate.COLUMN) - 1;
    }

    private boolean inMoveRight(Coordinate coordinate,int indexColor){
        if(indexColor==0 && coordinate.column>this.column){
            return true;
        } else if(indexColor==1 && coordinate.column<this.column){
            return true;
        } else{
            return false;
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
