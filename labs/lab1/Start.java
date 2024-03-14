package OOP.labs.lab1;
import java.util.Scanner;
public class Start {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        for(int i = 0;i < n; i++){
            for(int j = 0; j < n - i;j++){
                System.out.print(" ");
            }
            for(int j = 0; j < i * 2 - 1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
