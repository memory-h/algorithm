package geometry.gold.gold_5;
import java.io.*;
import java.util.StringTokenizer;
public class _2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] x = new long[n + 1];
        long[] y = new long[n + 1];

        long sumX = 0, sumY = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        // 신발끈 공식
        x[n] = x[0]; y[n] = y[0];

        for(int i = 0; i < n; i++) {
            sumX += x[i] * y[i + 1];
            sumY += x[i + 1] * y[i];
        }
        bw.write(String.format("%.1f", Math.abs(sumX - sumY) / 2.0));
        bw.flush();
        bw.close();
    }
}