package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        board.clear();
        currentPlayer = player1;
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Current Player: " + currentPlayer.getMarker());
            System.out.print("row (0-2): ");
            int x = scanner.nextInt();
            System.out.print("column (0-2): ");
            int y = scanner.nextInt();

            if (board.isCellEmpty(x, y)) {
                board.place(x, y, currentPlayer.getMarker());
                switchCurrentPlayer();
            } else {
                System.out.println("Cell is not empty! Choose another.");
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
        game.play();
    }
}

