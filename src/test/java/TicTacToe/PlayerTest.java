package TicTacToe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testGetMarker() {
        char expectedMarker = 'X';
        Player player = new Player(expectedMarker);

        char actualMarker = player.getMarker();

        assertEquals(expectedMarker, actualMarker);
    }

    @Test
    void testMarkerIsStoredCorrectly() {

        char marker = 'O';
        Player player = new Player(marker);

        assertEquals(marker, player.getMarker());
    }
}
