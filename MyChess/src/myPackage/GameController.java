package myPackage;

import java.util.Scanner;

public class GameController {
    private GameField gameField;
    private boolean whiteTurn;

    public void start() {
        gameField = new GameField();
        this.startGameLoop();
    }

    private void startGameLoop() {
        while (true) {
            try {
                this.print();
                Move move = readPlayerMove();
                gameField.makeMove(move);
            } catch (MyChessException e){
                printExceptionMessage(e);
            }

        }
    }

    private void printExceptionMessage(MyChessException e) {
        System.out.println(e.getMessage());
    }

    private Move readPlayerMove() {
        while (true) {
            Scanner sc = new Scanner(System.in);

            System.out.printf("It's %s turn. Enter your move: \n From: \n", this.gameField.isWhiteTurn() ? "white" : "black");
            String fromX = sc.nextLine();
            String fromY = sc.nextLine();


            System.out.println("To:");
            String toX = sc.nextLine();
            String toY = sc.nextLine();



            return new Move.Builder()
                    .from(new Coords.Builder()
                            .x((Integer.parseInt(fromX) - 1))
                            .y((Integer.parseInt(fromY) - 1))
                            .build())
                    .to(new Coords.Builder()
                            .x((Integer.parseInt(toX) - 1))
                            .y((Integer.parseInt(toY) - 1))
                            .build())
                    .build();
        }
    }

    private void print() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                System.out.print(gameField.getBoard()[i][j]);
            }
            System.out.println();
        }
    }
}
