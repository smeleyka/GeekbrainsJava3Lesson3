import java.io.*;
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

            fileToArray();
            sequenceToFile();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileToArray() throws IOException {

        File f = new File("test.txt");
        byte[] br = new byte[(int) f.length()];
        FileInputStream in = new FileInputStream(f);
       // BufferedReader di1 = new BufferedReader(new InputStreamReader(fi1,"UTF-8"));

        in.read(br);
        System.out.print(Arrays.toString(br));
    }

    public static void sequenceToFile () throws IOException {
        FileInputStream fi1 = new FileInputStream("test1.txt");
        FileInputStream fi2 = new FileInputStream("test2.txt");
        FileInputStream fi3 = new FileInputStream("test3.txt");
        FileInputStream fi4 = new FileInputStream("test4.txt");
        FileInputStream fi5 = new FileInputStream("test5.txt");

        Vector<FileInputStream> filesVector = new Vector();
        filesVector.add(fi1);
        filesVector.add(fi2);
        filesVector.add(fi3);
        filesVector.add(fi4);

        Enumeration<FileInputStream> e = filesVector.elements();
        SequenceInputStream seq = new SequenceInputStream(e);
        InputStreamReader isreader = new InputStreamReader(seq,"UTF-8");
        FileOutputStream fout = new FileOutputStream("output.txt");
        OutputStreamWriter outwriter = new OutputStreamWriter(fout,"UTF-8");
        int x;
        while ((x=isreader.read()) != -1){
            System.out.print((char)x);
            outwriter.write(x);
        }
        isreader.close();
        outwriter.close();
    }
}
