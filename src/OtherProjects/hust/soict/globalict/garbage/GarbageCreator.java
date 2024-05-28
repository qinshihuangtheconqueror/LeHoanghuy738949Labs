package OtherProjects.hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * It reads a file into a byte array, then converts the byte array into a string
 */
public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.exe";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char)b;
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime); // 83
    }

}