package TicTacToe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {
    public Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testBoardInitialization() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isCellEmpty(i, j));
            }
        }
    }

    @Test
    public void testPlaceMarker() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlaceMarkerOnNonEmptyCell() {
        board.place(0, 0, 'X');
        board.place(0, 0, 'O');
        assertEquals('X', getCell(0, 0));
    }

    @Test
    public void testClearBoard() {
        board.place(0, 0, 'X');
        board.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isCellEmpty(i, j));
            }
        }
    }
    private char getCell(int x, int y) {
        try {
            java.lang.reflect.Field cellsField = Board.class.getDeclaredField("cells");
            cellsField.setAccessible(true);
            char[][] cells = (char[][]) cellsField.get(board);
            return cells[x][y];
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
