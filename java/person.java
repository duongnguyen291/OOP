package OOP.java;
public class person{
    String name;
    int age;
    String adress;
    int id;
    double gpa;
    static String university = "Ha Noi University of Science and Technology";
    public person(String name, int age, String adress, int id, double gpa){
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.id = id;
        this.gpa = gpa;
    }
    public static void printInfo(){
        System.out.println("Hello Everyone! ");
        System.out.println("This is student of " + university);
    }
}
