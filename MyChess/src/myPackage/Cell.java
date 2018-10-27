package myPackage;

public class Cell {
    private Figure figure;

    public Cell(Figure figure) {
        if (figure == null) {
            throw new NullPointerException("myPackage.Figure can't be null");
        }

        this.figure = figure;
    }

    public Cell() {
    }

    public Figure figure() {
        return this.figure;
    }

    public boolean isEmpty() {
        return figure == null;
    }

    public void putFigure(Figure figure){
        this.figure = figure;
    }

    @Override
    public String toString() {
        return this.figure == null ? "\u2014" : figure.toString();
    }
}
