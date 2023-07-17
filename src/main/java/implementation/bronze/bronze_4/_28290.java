package implementation.bronze.bronze_4;
import java.io.*;
public class _28290 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        if(str.equals("fdsajkl;") || str.equals("jkl;fdsa")) bw.write("in-out");
        else if(str.equals("asdf;lkj") || str.equals(";lkjasdf")) bw.write("out-in");
        else if(str.equals("asdfjkl;")) bw.write("stairs");
        else if(str.equals(";lkjfdsa")) bw.write("reverse");
        else bw.write("molu");

        bw.flush();
        bw.close();
    }
}