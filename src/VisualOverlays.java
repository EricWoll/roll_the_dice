import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class VisualOverlays {
    private HashMap<String, String> overlays = new HashMap<>();

    public void addOverlay(String key, String value) {
        /**
         * @Param key (String) => name of the overlay
         * @Param value (String) => the text of the overlay
         * @Return none
         */
        overlays.put(key, value);
    }
    public void addOverlaysFile(String file) {
        /**
         * @Param file (String) => the file path of the text file with overlays
         * @Return none
         */
        String[] dataList;

        try {
            File valuesFile = new File(file);
            Scanner fileReader = new Scanner(valuesFile);

            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                dataList = (data.split(" : ", 2));
                overlays.put(dataList[0], dataList[1]);
                System.out.println(overlays);
            }

            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void removeOverlay(String overlayName) {
        overlays.remove(overlayName);
    }

    public void clearOverlays() {
        overlays.clear();
    }

    public void printOverlay(String overlayName) {
        System.out.println(overlays.get(overlayName));
    }
}
