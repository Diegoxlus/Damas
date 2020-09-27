package draughts.models;

public class CheckerBoard {

    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    public static final int INITIAL_ROW_INTERMEDIATE = 2;
    public static final int FINAL_ROW_INTERMEDIATE = 5;

    public Piece[][] pieces;

    public CheckerBoard() {
        this.pieces = new Piece[WIDTH][HEIGHT];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (isActiveSquare(i, j) || isIntermediateRow(i)) {
                    this.pieces[i][j] = new Men(Color.NULL_COLOR);
                } else {
                    this.putPiece(i, j);
                }
            }
        }
    }

    private void putPiece(int i, int j) {
        if (!this.isActiveSquare(i, j) && !this.isIntermediateRow(i)) {
            if (i < HEIGHT / 2 - 1) {
                this.pieces[i][j] = new Men(Color.BLACK_COLOR);
            } else if (i > HEIGHT / 2) {
                this.pieces[i][j] = new Men(Color.WHITE_COLOR);
            }
        }
    }

    private boolean isActiveSquare(int i, int j) {
        return (i + j) % 2 == 0;
    }

    private boolean isIntermediateRow(int row) {
        return row > INITIAL_ROW_INTERMEDIATE && row < FINAL_ROW_INTERMEDIATE;
    }

    boolean isOccupied(Coordinate coordinate, Color color) {
        return this.getColorPiece(coordinate).equals(color);
    }


    private Color getColorPiece(Coordinate coordinate) {
        return this.pieces[coordinate.getRow()][coordinate.getColumn()].getColor();
    }

    private void movePiece(Coordinate coordinate, Color color) {
        this.pieces[coordinate.getRow()][coordinate.getColumn()].setColor(color);
    }

    void move(Coordinate originCoordinate, Coordinate targetCoordinate) {
        Color originColor = this.getColorPiece(originCoordinate);
        this.movePiece(originCoordinate, Color.NULL_COLOR);
        this.movePiece(targetCoordinate, originColor);
    }

    void jump(Coordinate originCoordinate, Coordinate targetCoordinate) {
        Coordinate intermediateCoordinate = originCoordinate.getIntermediate(targetCoordinate);
        Color originColor = this.getColorPiece(originCoordinate);
        this.movePiece(originCoordinate, Color.NULL_COLOR);
        this.movePiece(intermediateCoordinate, Color.NULL_COLOR);
        this.movePiece(targetCoordinate, originColor);
    }

    boolean isDraughts() {
        int countWhites = 0;
        int countBlacks = 0;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; i < WIDTH; i++) {
                if (this.pieces[i][j].getColor() == Color.WHITE_COLOR) {
                    countWhites++;
                }
                if (this.pieces[i][j].getColor() == Color.BLACK_COLOR) {
                    countBlacks++;
                }
            }
        }
        return countWhites == 0 || countBlacks == 0;
    }


}
