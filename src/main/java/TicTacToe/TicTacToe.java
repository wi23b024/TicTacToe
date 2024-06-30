package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public Player player1;
    public Player player2;
    public Player currentPlayer;
    public Board board;

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

    public boolean hasWinner() {
        char[][] b = board.cells;
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (b[i][0] == b[i][1] && b[i][1] == b[i][2] && b[i][0] != ' ') return true;
            if (b[0][i] == b[1][i] && b[1][i] == b[2][i] && b[0][i] != ' ') return true;
        }
        // Check diagonals
        if (b[0][0] == b[1][1] && b[1][1] == b[2][2] && b[0][0] != ' ') return true;
        if (b[0][2] == b[1][1] && b[1][1] == b[2][0] && b[0][2] != ' ') return true;
        return false;
    }

    public boolean isDraw() {
        return board.isFull() && !hasWinner();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());
            System.out.print("row (0-2): ");
            int x = scanner.nextInt();
            System.out.print("column (0-2): ");
            int y = scanner.nextInt();

            if (board.isCellEmpty(x, y)) {
                board.place(x, y, currentPlayer.getMarker());
                if (hasWinner()) {
                    board.print();
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    break;
                } else if (isDraw()) {
                    board.print();
                    System.out.println("The game is a draw!");
                    break;
                }
                switchCurrentPlayer();
            } else {
                System.out.println("Cell is not empty! Choose another.");
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            game.start();
            game.play();

            System.out.print("Do you want to play again? (y/n): ");
            if (scanner.next().toLowerCase().charAt(0) != 'y') {
                break;
            }
        }
        scanner.close();
    }
}


