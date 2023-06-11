public class Tools {
    public static void printCopyright() {
        System.out.println("====================");
        System.out.println("    Roll the Dice");
        System.out.println("    by Eric Woll");
        System.out.println("====================\n");
    }

    public static void enterToContinue(String message) {
        System.out.println(message);
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


