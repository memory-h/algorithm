package bruteforce.silver.silver_4;
import java.io.*;
public class _4096 {
    public static boolean isPalindrome(String str) {
        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            if(str.equals("0")) break;

            int strLength = str.length();
            int count = 0;

            while(!isPalindrome(str)) {
                count++;

                int temp = Integer.parseInt(str);
                temp++;
                str = String.valueOf(temp);

                while(str.length() < strLength) {
                    str = "0" + str;
                }
            }
            sb.append(count + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}