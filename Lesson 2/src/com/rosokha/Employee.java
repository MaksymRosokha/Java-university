import java.time.LocalDate;

public class Employee {
    private String name;
    private Double salary;
    private LocalDate hireDate;
    private HomeAddress homeAddress;

    public Employee(String name, Double salary, LocalDate hireDate, HomeAddress homeAddress) {
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
        this.homeAddress = homeAddress;
    }

    public Employee(String name, LocalDate hireDate, HomeAddress homeAddress) {
        this.name = name;
        this.salary = 5000.0;
        this.hireDate = hireDate;
        this.homeAddress = homeAddress;
    }

    public void getInfo() {
        System.out.println("------------------------------------------------------");
        System.out.println("Name: " + this.name);
        System.out.println("Salary: " + this.salary);
        System.out.println("Hire date: " + this.hireDate);
        System.out.println("Home address: " + this.homeAddress.getHomeAddress());
    }

    public void setNewAddress(HomeAddress newAddress) {
        this.homeAddress = newAddress;
    }

    public void raiseSalary(Double byPercent) {
        this.salary += (this.salary * byPercent / 100);
    }
}
