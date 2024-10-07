public class Employee {

    private static int idGeneratar = 1;

    private int id;
    private String fullName;
    private int department;
    private  int salary;

    public Employee(String fullName, int department, int salary){
        id = idGeneratar++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", salary=" + salary;
    }
}
