package implementation.gold.gold_5;
import java.io.*;
import java.util.StringTokenizer;
public class _8981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] x = new int[101];

        for (int i = 0; i < 101; i++) x[i] = 0;
        int value = 0, from = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            from = (from + value) % n;
            value = x[from];

            while (value > 0) {
                from = (from + 1) % n;
                value = x[from];
            }
            x[from] = num;
            value = num;
        }
        bw.write(n + "\n");

        for (int i = 0; i < n; i++) bw.write(x[i] + " ");

        bw.flush();
        bw.close();
    }
}