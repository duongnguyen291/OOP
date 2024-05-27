package theory.week12;
import java.io.FileWriter;
import java.io.IOException;

public class GhiFile{
    public static void main(String[] args){
        try{
            FileWriter writer = new FileWriter("text.txt");
            for(char ch = 'A';ch <= 'J';ch++){
                writer.write(ch + "\n");
            }
            writer.close();
            System.out.println("Ghi file thanh cong");
        }catch(IOException e){
            System.out.println("Da xay ra loi khi ghi ten file : " + e.getMessage());
        }
    }
}