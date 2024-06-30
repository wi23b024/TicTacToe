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
        assertEquals('X', game.currentPlayer.getMarker());
        assertTrue(isBoardClear(game.board));
    }

    @Test
    void testSwitchCurrentPlayer() {
        game.start();
        game.switchCurrentPlayer();
        assertEquals('O', game.currentPlayer.getMarker());
        game.switchCurrentPlayer();
        assertEquals('X', game.currentPlayer.getMarker());
    }

    @Test
    void testHasWinner() {
        game.start();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');
        assertTrue(game.hasWinner());

        game.start();
        game.board.place(0, 0, 'O');
        game.board.place(1, 1, 'O');
        game.board.place(2, 2, 'O');
        assertTrue(game.hasWinner());

        game.start();
        game.board.place(0, 0, 'X');
        game.board.place(1, 0, 'X');
        game.board.place(2, 0, 'X');
        assertTrue(game.hasWinner());
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
        assertTrue(game.isDraw());

        game.start();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.board.place(0, 2, 'X');
        game.board.place(1, 0, 'X');
        game.board.place(1, 1, 'O');
        game.board.place(1, 2, 'X');
        game.board.place(2, 0, 'O');
        game.board.place(2, 1, 'X');
        assertFalse(game.isDraw());
    }

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

}