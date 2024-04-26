
public class NoGarbage {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append("a"); // append 10000 a vào Stringbuilder
        }
        String s=sb.toString();
        System.out.println(System.currentTimeMillis()-start);
        }
    }