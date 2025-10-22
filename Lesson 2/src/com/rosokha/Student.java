public class Student {
    private int age;
    private String name;
    private int height;

    public Student(){
        System.out.println("Empty constructor Student()");
    }

    public Student(int age, String name, int height){
        System.out.println("Constructor Student(int age, String name, int height)");
        this.age = age;
        this.name = name;
        this.height = height;
    }
}
