package OOP.java;
public class test{
    public static void main(String[] args){
        person a = new person("Duong", 21, "40A ngo 62 Bao Linh",20225966,4.0);
        person.printInfo();
        System.out.println(a.name);
        student b = new student("Manh",20,"Hoang Mai",20225956,4.0,"Ke toan");
        b.printStudentInfo();
    }
}