package bruteforce;
import java.io.*;
public class _2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[11];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int sum1 = 0, sum2 = 0;

        for(int i = 1; i <= 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum1 += arr[i];
            sum2 += arr[i];

            if(sum1 <= 100) max = Math.max(max, sum1);
            if(sum2 > 100) min = Math.min(min, sum2);
        }
        if(Math.abs(100 - max) >= Math.abs(100 - min)) bw.write(String.valueOf(min));
        else bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
    }
}