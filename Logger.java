import java.io.*;
import java.time.LocalDateTime;
//import java.util.logging.Logger;

//Logging text file creation 
public class Logger {
    private static final String LOG_FILE = "logTextFile.txt";

    public static void log(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            fw.write(LocalDateTime.now() + " - " + message + "\n");
        } catch (IOException e) {
            System.out.println("Logging failed: " + e.getMessage());
        }
    }
}