package myPackage;
public class Pawn extends Figure {

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean checkTheoreticalCorrectness(Move move) {
        int diffY = move.to.y - move.from.y;
        int diffX = move.to.x - move.from.y;


        if (isWhite && (diffY < 0 || diffY > 2)) {
            return false;
        } else if (!isWhite && (diffY > 0 || diffY < -2)) {
            return false;
        }

        if (diffX != 0 && diffX != 1) {
            return false;
        }

        if (diffX == 1 && Math.abs(diffY) != 1) {
            return false;
        }

        return true;
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
