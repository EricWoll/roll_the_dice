import static org.junit.jupiter.api.Assertions.*;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class PlayerControllerTest {

    private int initialLives = 3;
    private PlayerController pController = new PlayerController(false, initialLives);
    private PlayerController aController = new PlayerController(true, initialLives);

    @Test
    @DisplayName("PlayerController SetUp")
    @Description("Test all of the PlayerController Setup")
    public void testPlayerControllerInit() {
        assertEquals(false, pController.isAi());
        assertEquals(true, aController.isAi());

        assertEquals(3, pController.getLives());

        assertEquals(3, pController.getMaxLives());
    }

    @Test
    @DisplayName("Lives Boundaries")
    @Description("Checks if Lives stay within Max lives and 0")
    public void testLivesBoundaries() {
        pController.setLives(10);
        aController.setLives(-10);

        assertEquals(initialLives, pController.getLives());
        assertEquals(0, aController.getLives());

    }

    @Test
    @DisplayName("Lives Dynamic Changes")
    @Description("Lives can be changed after initialization")
    public void testLivesDynamic() {
        pController.setLives(initialLives);
        pController.removeLife();
        assertEquals(initialLives - 1, pController.getLives());

        aController.setLives(initialLives);
        aController.setLives(initialLives - 2);
        assertEquals(initialLives - 2, aController.getLives());
    }


    @Test
    @DisplayName("Random Number Boundaries Check")
    @Description("Random Number between 1 and 6")
    @RepeatedTest(20)
    public void testRandomNumGen() {
        pController.generateRoll();
        aController.generateRoll();

        assertTrue(0 < pController.getRoll() && pController.getRoll() < 7);
        assertTrue(0 < aController.getRoll() && aController.getRoll() < 7);
    }

    @Test
    @DisplayName("Default Name Check")
    @Description("Name has been not set ['Name not set']")
    public void testNameSet() {
        pController.setName();
        aController.setName();

        assertEquals("Name not set", pController.getName());
        assertEquals("Name not set", aController.getName());
    }

}