package myPackage;

public class Pawn extends Figure {

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean checkTheoreticalCorrectness(Move move, Cell to) {
        int diffY = (move.from.y ) - (move.to.y );
        int diffX = (move.from.x ) - (move.to.x );


        if (diffY == 0) {
            if (isWhite && ((move.from.x + 1) == 7)) {
                if (diffX == 1 || diffX == 2) {
                    return true;
                }
            } else if (!isWhite && ((move.from.x + 1) == 2)) {
                if (diffX == -1 || diffX == -2) {
                    return true;
                }
            } else if (isWhite){
                if (diffX == 1 ){
                    return true;
                }
            } else if (!isWhite){
                if (diffX == -1){
                    return true;
                }
            }
        } else if ((Math.abs(diffY) == 1) && !canMoveForward(to)){
            if (isWhite){
                if (diffX == 1){
                    return true;
                }
            } else if (!isWhite){
                if (diffX == -1){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canMoveForward(Cell to){
        if (to.toString().equals("\u2014")) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.isWhite) {
            return "\u2659";
        } else {
            return "\u265F";
        }
    }

}
