import java.util.Hashtable;
import java.util.Dictionary;
import java.util.Enumeration;

public class Main {


    public static void main(String args[]) {
        VisualOverlays overlays = new VisualOverlays();

        overlays.addOverlaysFile("./overlay_files/example.txt");
        overlays.printOverlay("Opening");
        overlays.clearOverlays();

    }
}
