import java.util.Random;

public class Main {

    private static final Random RANDOM = new Random();
    private static final String[] NAMES = {"Сергей", "Олег", "Иван", "Данил", "Илья", "Артем"};
    private static final String[] SURNAMES = {"Захаров", "Доннов", "Зингов", "Ренов", "Белов", "Жидов"};
    private static final String[] PATRONYMIC_NAMES = {"Александрович", "Дмитриевич", "Сергеевич", "Алексеевич", "Андреевич", "Григорьевич"};


    private  static final Employee[] EMPLOYEES = new Employee[10];

    private static void initEmployee() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = SURNAMES[RANDOM.nextInt(0, SURNAMES.length)] + " " +
              NAMES[RANDOM.nextInt(0, NAMES.length)] + " " +
                    PATRONYMIC_NAMES[RANDOM.nextInt(0, PATRONYMIC_NAMES.length)];
            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(0,6), RANDOM.nextInt(40_000, 80_000));
        }
    }

    public static void main(String[] args) {
        initEmployee();
        print();
        System.out.println("Сумму затрат на зарплату в месяц " + calculateSumOfMonth());
        System.out.println("Cотрудник с минимальной зарплатой " + employeeWithMinSalary());
        System.out.println("Cотрудник с максимальной зарплатой " + employeeWithMaxSalary());
        System.out.println("Cреднее значение зарплат " + averegeSalary());
        printName();
    }

    private static void print() {
        for ( Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static int calculateSumOfMonth(){
        int sum = 0;
        for ( Employee employee : EMPLOYEES) {
            sum+=employee.getSalary();
        }
        return sum;
    }

    private static Employee employeeWithMinSalary(){
        Employee employeeMinSalary = null;
        for ( Employee employee : EMPLOYEES) {
            if(employeeMinSalary == null || employee.getSalary() < employeeMinSalary.getSalary()){
                employeeMinSalary = employee;
            }
        }
        return employeeMinSalary;
    }

    private static Employee employeeWithMaxSalary(){
        Employee employeeMaxSalary = null;
        for ( Employee employee : EMPLOYEES) {
            if(employeeMaxSalary == null || employee.getSalary() > employeeMaxSalary.getSalary()){
                employeeMaxSalary = employee;
            }
        }
        return employeeMaxSalary;
    }

    private static double averegeSalary(){
        return (double) calculateSumOfMonth() / EMPLOYEES.length;
    }
    private static void printName() {
        for ( Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }

}