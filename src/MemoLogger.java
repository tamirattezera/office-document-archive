import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MemoLogger {

    private static final String FILE_NAME = "memos.txt";

    public static void main(String[] args) {
        writeMemos();
        readMemos();
    }

    private static void writeMemos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

            writer.println("2026-09-01 | Staff Meeting | Tamirat Tezera");
            writer.println("2026-09-02 | Quarterly Report | Hana Tesfaye");
            writer.println("2026-09-03 | Office Supplies | Abebe Kebede");
            writer.println("2026-09-04 | Client Call | Selamawit Bekele");
            writer.println("2026-09-05 | Project Timeline | Dawit Alemu");
            writer.println("2026-09-06 | Server Maintenance | Natnael Girma");

            System.out.println("Memos written successfully to " + FILE_NAME);

        } catch (IOException e) {
            System.err.println("Error writing memos: " + e.getMessage());
        }
    }

    private static void readMemos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            int sequenceNumber = 1;

            System.out.println("\n----- Memo Log -----");

            while ((line = reader.readLine()) != null) {
                System.out.println(sequenceNumber + ". " + line);
                sequenceNumber++;
            }

            System.out.println("--------------------");

        } catch (IOException e) {
            System.err.println("Error reading memos: " + e.getMessage());
        }
    }
}