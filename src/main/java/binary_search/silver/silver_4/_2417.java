package binary_search.silver.silver_4;
import java.io.*;
public class _2417 {
    private static long binarySearch(long n) {
        long start = 0L, end = n;
        long value = 0L;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (Math.pow(mid, 2) >= n) {
                end = mid - 1;
                value = mid;
            }
            else start = mid + 1;
        }

        return value;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        bw.write(String.valueOf(binarySearch(n)));
        bw.flush();
        bw.close();
    }
}