import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DocumentBackup {

    private static final String SOURCE_FILE = "source/sample.pdf";
    private static final String FILE_STREAM_BACKUP = "backup/sample-filestreams.pdf";
    private static final String BUFFERED_STREAM_BACKUP = "backup/sample-buffered.pdf";

    public static void main(String[] args) {
        copyWithFileStreams();
        copyWithBufferedStreams();
    }

    // Copies the binary file using FileInputStream and FileOutputStream
    private static void copyWithFileStreams() {
        long totalBytes = 0;
        byte[] buffer = new byte[4096];

        try (FileInputStream input = new FileInputStream(SOURCE_FILE);
             FileOutputStream output = new FileOutputStream(FILE_STREAM_BACKUP)) {

            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }

            System.out.println(
                    "[FileStreams] Total bytes copied: " + totalBytes
            );

        } catch (IOException e) {
            System.err.println(
                    "Error during FileStreams copy: " + e.getMessage()
            );
        }
    }

    // Copies the binary file using BufferedInputStream and BufferedOutputStream
    private static void copyWithBufferedStreams() {
        long totalBytes = 0;
        byte[] buffer = new byte[4096];

        try (BufferedInputStream input =
                     new BufferedInputStream(new FileInputStream(SOURCE_FILE));
             BufferedOutputStream output =
                     new BufferedOutputStream(new FileOutputStream(BUFFERED_STREAM_BACKUP))) {

            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }

            System.out.println(
                    "[BufferedStreams] Total bytes copied: " + totalBytes
            );

        } catch (IOException e) {
            System.err.println(
                    "Error during BufferedStreams copy: " + e.getMessage()
            );
        }
    }
}