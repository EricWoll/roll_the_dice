public class Ai extends PlayerController {

    public Ai(boolean isAi, byte lives) {
        super(isAi, lives);
    }

    public void generateName(String file) {
        // Create name file (csv file), create file reader, create line selector
        name = "Ai";
    }
}
