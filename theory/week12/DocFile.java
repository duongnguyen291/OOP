package theory.week12;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class DocFile{
    public static void main(String[] args){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        }
        catch(IOException e){
            System.out.println("Da co loi xay ra khi doc file" + e.getMessage());
        }
    }
}