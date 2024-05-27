package theory.week12;
import java.util.Scanner;

public class XuLyNgoaiLe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer intNumber = null;

        try {
            System.out.println("Hãy nhập vào một số nguyên: ");
            String strNumber = input.nextLine();
            intNumber = Integer.parseInt(strNumber);
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập vào một số nguyên");
        }

        if (intNumber != null) {
            System.out.println("Chuyển thành Hexa: " + Integer.toHexString(intNumber));
        } else {
            System.out.println("Không thể chuyển đổi sang Hexa do nhập liệu không hợp lệ.");
        }
    }
}
