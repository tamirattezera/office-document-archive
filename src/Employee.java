import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int empId;
    private String fullName;
    private String position;
    private double salary;

    // Constructors
    public Employee() {
    }

    public Employee(int empId, String fullName, String position, double salary) {
        this.empId = empId;
        this.fullName = fullName;
        this.position = position;
        this.salary = salary;
    }

    // Getters and Setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}