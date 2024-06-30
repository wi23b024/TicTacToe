package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
    }

    @Test
    void testStart() {
        game.start();
        assertEquals('X', game.currentPlayer.getMarker(), "The current player should be player1 with marker 'X'");
        assertTrue(isBoardClear(game.board), "The board should be cleared at the start of the game");
    }

    @Test
    void testSwitchCurrentPlayer() {
        game.start();
        game.switchCurrentPlayer();
        assertEquals('O', game.currentPlayer.getMarker(), "The current player should switch to player2 with marker 'O'");
        game.switchCurrentPlayer();
        assertEquals('X', game.currentPlayer.getMarker(), "The current player should switch back to player1 with marker 'X'");
    }

    @Test
    void testHasWinner() {
        game.start();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');
        assertTrue(game.hasWinner(), "Player X should win with a horizontal line");

        game.start();
        game.board.place(0, 0, 'O');
        game.board.place(1, 1, 'O');
        game.board.place(2, 2, 'O');
        assertTrue(game.hasWinner(), "Player O should win with a diagonal line");

        game.start();
        game.board.place(0, 0, 'X');
        game.board.place(1, 0, 'X');
        game.board.place(2, 0, 'X');
        assertTrue(game.hasWinner(), "Player X should win with a vertical line");
    }

    @Test
    void testIsDraw() {
        game.start();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.board.place(0, 2, 'X');
        game.board.place(1, 0, 'X');
        game.board.place(1, 1, 'O');
        game.board.place(1, 2, 'X');
        game.board.place(2, 0, 'O');
        game.board.place(2, 1, 'X');
        game.board.place(2, 2, 'O');
        assertTrue(game.isDraw(), "The game should be a draw");

        game.start();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.board.place(0, 2, 'X');
        game.board.place(1, 0, 'X');
        game.board.place(1, 1, 'O');
        game.board.place(1, 2, 'X');
        game.board.place(2, 0, 'O');
        game.board.place(2, 1, 'X');
        assertFalse(game.isDraw(), "The game should not be a draw since not all cells are filled");
    }

    // Helper method to check if the board is cleared
    private boolean isBoardClear(Board board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.cells[i][j] != ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    //finish
}