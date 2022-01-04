import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * @author zhanglei211 on 2021/9/15.
 */
public class Main {

    static {
        String str = "1 2 3\n" + "4 5 6\n" + "7 8 0\n";
        byte[] bytes = str.getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        System.setIn(byteArrayInputStream);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strArr = scanner.nextLine().split(" ");
        for (String s : strArr) {
            System.out.print(s + " ");
        }
    }
}
