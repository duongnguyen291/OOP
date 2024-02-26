public class student extends person{
    String major;
    public student(String name,int age, String adress, int id,double gpa,String major){
        super(name,age,adress,id,gpa);
        this.major = major;
    }
    public void printStudentInfo(){
        System.out.println("This is Student object!");
        System.out.println("Full name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Student adress: " + this.adress);
        System.out.println("Student ID: " + this.id);
        System.out.println("Student GPA: " + this.gpa);
        System.out.println("Student major: " + this.major);
        
    }
}
