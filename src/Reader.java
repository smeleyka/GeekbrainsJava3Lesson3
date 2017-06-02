import java.io.*;
import java.util.Scanner;

/**
 * Created by smele on 01.06.2017.
 */
public class Reader {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        File f = new File(sc.nextLine());
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
            byte[] b = new byte[100];
            int x;
            read
            while ()


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
