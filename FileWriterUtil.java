import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtil {
    public static void writeToFile(double weight, double height, String bodyType, String heightType) {
        try (FileWriter writer = new FileWriter("person_data.txt", true)) {
            writer.write("Weight: " + weight + " kg\n");
            writer.write("Height: " + height + " m\n");
            writer.write("Body Type: " + bodyType + "\n");
            writer.write("Height: " + heightType + "\n");
            writer.write("---------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
