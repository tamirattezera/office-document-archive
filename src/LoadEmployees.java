import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadEmployees {

    private static final String FILE_NAME = "data/employeeRecords.dat";

    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Employee employee1 = (Employee) ois.readObject();
            Employee employee2 = (Employee) ois.readObject();
            Employee employee3 = (Employee) ois.readObject();

            System.out.println(
                    "============================================================="
            );
            System.out.printf(
                    "%-6s %-20s %-22s %10s%n",
                    "ID", "Name", "Position", "Salary"
            );
            System.out.println(
                    "============================================================="
            );

            printEmployee(employee1);
            printEmployee(employee2);
            printEmployee(employee3);

            System.out.println(
                    "============================================================="
            );

        } catch (IOException e) {
            System.err.println(
                    "Error reading employee records: " + e.getMessage()
            );

        } catch (ClassNotFoundException e) {
            System.err.println(
                    "Employee class not found: " + e.getMessage()
            );
        }
    }

    private static void printEmployee(Employee employee) {
        System.out.printf(
                "%-6d %-20s %-22s %10.2f%n",
                employee.getEmpId(),
                employee.getFullName(),
                employee.getPosition(),
                employee.getSalary()
        );
    }
}