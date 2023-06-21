import static org.junit.jupiter.api.Assertions.assertEquals;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
class PlayerTest {

    private Player player = new Player(false, 3);

    @Test
    @DisplayName("Check continuePlaying")
    public void testContinuePlaying() {
        player.setContinuePlaying(false);
        assertEquals(false, player.getContinuePlaying());
    }
}