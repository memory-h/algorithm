package implementation.silver.silver_5;
import java.io.*;
public class _1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String number = br.readLine();
        int[] arr = new int[10];
        int max = 0;

        for(int i = 0; i < number.length(); i++) {
            int tmp = number.charAt(i) - '0';

            if(tmp == 9) tmp = 6;
            arr[tmp]++;
        }
        arr[6] = arr[6] / 2 + arr[6] % 2;
        for(int i = 0; i < 10; i++) max = Math.max(max, arr[i]);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}