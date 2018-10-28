package myPackage;

public abstract class Figure {
    boolean isWhite;

    public Figure(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    abstract public boolean checkTheoreticalCorrectness(Move move, Cell to);
    public abstract String toString();
}
