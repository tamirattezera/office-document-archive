import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.SequenceInputStream;

public class CombineReports {

    private static final String MORNING_FILE = "data/morningShift.txt";
    private static final String EVENING_FILE = "data/eveningShift.txt";
    private static final String COMBINED_FILE = "data/dailyAttendance.txt";

    public static void main(String[] args) {
        createShiftReports();
        combineReports();
    }

    private static void createShiftReports() {
        try (FileWriter morning = new FileWriter(MORNING_FILE);
             FileWriter evening = new FileWriter(EVENING_FILE)) {

            morning.write("Morning Shift Attendance Report\n");
            morning.write("--------------------------------\n");
            morning.write("Eden   - Present\n");
            morning.write("Tamirat     - Present\n");
            morning.write("Kaleab - Absent\n");

            evening.write("Evening Shift Attendance Report\n");
            evening.write("--------------------------------\n");
            evening.write("Hiwot - Present\n");
            evening.write("Eva   - Absent\n");
            evening.write("Frank - Present\n");

            System.out.println("Shift report files created successfully.");

        } catch (IOException e) {
            System.err.println(
                    "Error creating shift report files: " + e.getMessage()
            );
        }
    }

    private static void combineReports() {
        try (FileInputStream morning = new FileInputStream(MORNING_FILE);
             FileInputStream evening = new FileInputStream(EVENING_FILE);
             SequenceInputStream combined =
                     new SequenceInputStream(morning, evening);
             FileOutputStream output = new FileOutputStream(COMBINED_FILE)) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = combined.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            System.out.println(
                    "Reports combined successfully into " + COMBINED_FILE
            );

        } catch (IOException e) {
            System.err.println(
                    "Error combining reports: " + e.getMessage()
            );
        }
    }
}