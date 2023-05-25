import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        String operatingSystem = System.getProperty("os.name");

        Scanner clear = new Scanner(System.in);

        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");

        Game game = new Game();

        game.addPlayers(p1);
        game.addPlayers(p2);

        game.printPlayers();

        clear.nextLine();
        System.out.println("clearing");
        Tools.Clear(operatingSystem);

        System.out.println("cleared");
        clear.nextLine();


    }
}
