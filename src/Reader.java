import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.Scanner;

/**
 * Created by smele on 01.06.2017.
 */
public class Reader {
    public static Scanner sc = new Scanner(System.in);
    public static File source;

    public static void main(String[] args) {
        System.out.println("Укажите путь к файлу");
        source = new File(sc.nextLine());

        if (!source.exists()) {
            while (!source.exists()) {
                System.out.println("Файла не существует.");
                source = new File(sc.nextLine());
            }
        }

        try (BufferedReader bread = new BufferedReader(new InputStreamReader(new FileInputStream(source), "UTF-8"))) {

            char[] c = new char[1800];
            while (bread.read(c) > 0) {
                System.out.print(new String(c));
                System.out.println();
                if (sc.nextLine().equals("x")) break;
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
