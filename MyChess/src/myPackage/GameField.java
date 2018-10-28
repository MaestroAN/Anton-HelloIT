package myPackage;

public class GameField {
    private Cell[][] board; /*Entire size of game field*/
    private boolean whiteTurn; /*Moze luchse controller reshaet?*/


    public GameField() {
        this.board = new Cell[8][8];
        this.whiteTurn = true;

        this.initBoard();

        this.fillPawns(false);
        this.fillPawns(true);
    }

    private void fillPawns(boolean isWhite) {
        int rowIndex = isWhite ? 6 : 1;

        for (int i = 0; i < 8; ++i) {
            board[rowIndex][i].putFigure(new Pawn(isWhite));
        }
    }

    //    validate cords
    boolean coordsInBound(Move move) {
        if (move.from.y >= 0
                && move.from.x >= 0
                && move.from.x <= 7
                && move.from.y <= 7
                && move.to.x >= 0
                && move.to.y >= 0
                && move.to.x <= 7
                && move.to.y <= 7) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isWhiteTurn() {
        return whiteTurn;
    }

    public Cell[][] getBoard() {
        return this.board;
    }

    private void initBoard() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                board[i][j] = new Cell();
            }
        }
    }


    public void makeMove(Move move) throws MyChessException {
        if (!this.coordsInBound(move)) {
            throw new MyChessException("Coordinates out of bounds");
        } else {
            Pawn pawn = new Pawn(whiteTurn);
            Cell from = board[move.from.x][move.from.y];
            Cell to = board[move.to.x][move.to.y];
            if (from.isEmpty()) {
                throw new MyChessException("Cell is Empty, pick another Cell");
            } else if (from.figure().isWhite != this.whiteTurn) {
                throw new MyChessException("You try to move figure of another color, try to pick  figure of your color");
            } else if (!pawn.checkTheoreticalCorrectness(move , to )){
                throw  new MyChessException("This figure can't move like that");
            } else {
                board[move.to.x][move.to.y] = from;
                board[move.from.x][move.from.y] = new Cell();
                this.whiteTurn = !this.whiteTurn;
            }
        }
    }
}
