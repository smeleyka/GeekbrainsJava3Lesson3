import java.io.*;
import java.util.*;

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
        in.read(br);
        System.out.print(Arrays.toString(br));
    }

    public static void sequenceToFile () throws IOException {
        FileInputStream fi1 = new FileInputStream("test1.txt");
        FileInputStream fi2 = new FileInputStream("test2.txt");
        FileInputStream fi3 = new FileInputStream("test3.txt");
        FileInputStream fi4 = new FileInputStream("test4.txt");
        FileInputStream fi5 = new FileInputStream("test5.txt");
        FileOutputStream fout = new FileOutputStream("output.txt");

        // Не понял как сделать через ArrayList

        Vector<FileInputStream> filesVector = new Vector();
        filesVector.add(fi1);
        filesVector.add(fi2);
        filesVector.add(fi3);
        filesVector.add(fi4);
        filesVector.add(fi5);

        ArrayList<FileInputStream> filesArrayList = new ArrayList<>();
        filesArrayList.add(fi1);
        filesArrayList.add(fi2);
        filesArrayList.add(fi3);
        filesArrayList.add(fi4);
        filesArrayList.add(fi5);

        SequenceInputStream seqArLi = new SequenceInputStream(Collections.enumeration(filesArrayList));

        Enumeration<FileInputStream> e = filesVector.elements();
        SequenceInputStream seq = new SequenceInputStream(e);

        BufferedReader breader = new BufferedReader(new InputStreamReader(seq,"UTF-8"));
        BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(fout,"UTF-8"));
        //int x;
        while ((breader.read()) != -1){
            System.out.print((char)breader.read());
            bwriter.write(breader.read());
        }
        breader.close();
        bwriter.close();
    }
}
