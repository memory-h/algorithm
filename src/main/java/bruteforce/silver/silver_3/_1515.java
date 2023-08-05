package bruteforce.silver.silver_3;
import java.io.*;
public class _1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        boolean check = false;
        int findNumber = 0, index = 0;

        for(int i = 1; ; i++) {
            String temp = String.valueOf(i);
            findNumber++;

            for(int j = 0; j < temp.length(); j++) {
                if(str.charAt(index) == temp.charAt(j)) index++;

                if(index == str.length()) {
                    check = true;
                    break;
                }
            }
            if(check) break;
        }
        bw.write(String.valueOf(findNumber));
        bw.flush();
        bw.close();
    }
}