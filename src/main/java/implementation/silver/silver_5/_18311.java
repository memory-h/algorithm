package implementation.silver.silver_5;
import java.io.*;
import java.util.StringTokenizer;
public class _18311 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        int[] arr = new int[n];
        boolean check = false;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            k -= arr[i];

            if (k < 0) {
                bw.write(String.valueOf(i + 1));
                check = true;
                break;
            }
        }
        if (!check) {
            for (int i = n - 1; i >= 0; i--) {
                k -= arr[i];

                if (k < 0) {
                    bw.write(String.valueOf(i + 1));
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}