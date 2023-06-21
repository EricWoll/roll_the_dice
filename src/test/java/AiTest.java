import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AiTest {
    private Ai ai = new Ai(true, 3);

    @Test
    @DisplayName("Name Assignment")
    @Description("Check that Ai name was appropriately selected and assigned [Not all completed]")
    @RepeatedTest(20)
    public void testNameAssign() {
        ai.setName("");
        assertEquals("Ai", ai.getName());
    }
}