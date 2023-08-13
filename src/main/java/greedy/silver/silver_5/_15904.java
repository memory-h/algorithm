package greedy.silver.silver_5;
import java.io.*;
public class _15904 {
    private static boolean findUCPC(String temp, String ucpc) {
        int index = 0, count = 0;

        for(int i = 0; i < temp.length(); i++) {
            if(ucpc.charAt(index) == temp.charAt(i)) {
                index++;
                count++;
            }
            if(index == ucpc.length()) break;
        }
        if(count == 4) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String ucpc = "UCPC", temp = "";

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 65 && str.charAt(i) <= 90) temp += str.charAt(i);
        }
        if(temp.equals("UCPC") || findUCPC(temp, ucpc)) bw.write("I love UCPC");
        else bw.write("I hate UCPC");

        bw.flush();
        bw.close();
    }
}