package bruteforce.bronze.bronze_1;
import java.io.*;
public class _1526 {
    static boolean check;
    public static int maxNumber(int num) {
        if(num == 0) return num;

        if(num % 10 != 4 && num % 10 != 7) {
            check = false;
            return num;
        }
        return maxNumber(num / 10);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int max = 0;

        for(int i = 4; i <= n; i++) {
            check = true;
            maxNumber(i);

            if(check) max = Math.max(max, i);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}