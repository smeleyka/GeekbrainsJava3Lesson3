import jdk.internal.util.xml.impl.Input;
import sun.awt.shell.ShellFolder;

import java.io.*;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by admin on 31.05.2017.
 */
public class Main {

    public static void main(String[] args) {
        try {
            File[] farr  = {new File("test1.txt"),new File("test2.txt")};
            File f  = new File("test.txt");
            byte[] br = new byte[(int) f.length()];
            System.out.println(f.length());
            //SequenceInputStream seq = new SequenceInputStream()
            FileInputStream fi = new FileInputStream("test.txt");
            FileInputStream fi1 = new FileInputStream("test1.txt");
            FileInputStream fi2 = new FileInputStream("test2.txt");
            FileInputStream fi3 = new FileInputStream("test3.txt");
            FileInputStream fi4 = new FileInputStream("test4.txt");

            ArrayList<FileInputStream> fileList= new ArrayList<>();
            fileList.add(fi);
            fileList.add(fi1);
            fileList.add(fi2);
            fileList.add(fi3);
            fileList.add(fi4);

            Vector <FileInputStream> filesVector = new Vector();
            filesVector.add(fi);
            filesVector.add(fi1);
            filesVector.add(fi2);
            filesVector.add(fi3);
            filesVector.add(fi4);

           Enumeration <FileInputStream> e;
           e = filesVector.elements();








            FileInputStream in = new FileInputStream(f);
            in.read(br);
                System.out.print(Arrays.toString(br));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
