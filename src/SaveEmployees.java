import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveEmployees {

    private static final String FILE_NAME = "data/employeeRecords.dat";

    public static void main(String[] args) {

        Employee employee1 = new Employee(
                101,
                "Alice Johnson",
                "Software Engineer",
                75000.00
        );

        Employee employee2 = new Employee(
                102,
                "Bob Smith",
                "Project Manager",
                85000.00
        );

        Employee employee3 = new Employee(
                103,
                "Carol Davis",
                "QA Analyst",
                65000.00
        );

        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(employee1);
            oos.writeObject(employee2);
            oos.writeObject(employee3);

            System.out.println(
                    "Employee records serialized to " + FILE_NAME
            );

        } catch (IOException e) {
            System.err.println(
                    "Error serializing employees: " + e.getMessage()
            );
        }
    }
}