import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    public static void task1() {
        System.out.println("\nTask 1");
        Student student1 = new Student();
        Student student2 = new Student(20, "Alex", 200);
    }

    public static void task2() {
        System.out.println("\nTask 2");
        StringUtils su = new StringUtils();
        System.out.println();
        System.out.println("Are eat and tea anagram? " + su.isAnagram("eat", "tea"));
        System.out.println("Are saw and wwwas anagram? " + su.isAnagram("saw", "wwwas"));
        System.out.println("Are raw and abc anagram? " + su.isAnagram("raw", "abc"));
    }

    public static void task3() {
        System.out.println("\nTask 3");
        HomeAddress hm1 = new HomeAddress("Aleja 2");
        Employee e1 = new Employee("Pawel", 4020.0, LocalDate.of(2018, 5, 19), hm1);
        HomeAddress hm2 = new HomeAddress("Centrum 5");
        Employee e2 = new Employee("Jakub", 8000.0, LocalDate.of(2011, 7, 21), hm2);
        HomeAddress hm3 = new HomeAddress("Krakowska 15");
        Employee e3 = new Employee("Wiktoria", 2135.6, LocalDate.of(2023, 12, 1), hm3);

        e1.getInfo();
        e2.getInfo();
        e3.getInfo();

        e1.raiseSalary(5.0);
        e2.raiseSalary(10.0);
        e3.raiseSalary(15.8);

        e1.getInfo();
        e2.getInfo();
        e3.getInfo();
    }

    public static void task4(){
        System.out.println("\nTask 4");
        HomeAddress hm1 = new HomeAddress("Aleja 2");
        Employee e1 = new Employee("Pawel", LocalDate.of(2018, 5, 19), hm1);
        e1.getInfo();
        e1.raiseSalary(10.0);
        e1.getInfo();
    }
}