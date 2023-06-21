public class Ai extends PlayerController {

    public Ai(boolean isAi, int lives) {
        super(isAi, lives);
    }

    public void setName(String file) {
        // Create name file (csv file), create file reader, create line selector
        name = "Ai";
    }
}
