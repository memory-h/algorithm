package greedy.silver.silver_4;
import java.io.*;
public class _2847 {
    static int count = 0;
    private static int score(int preValue, int nextValue) {
        while(preValue <= nextValue) {
            nextValue--;
            count++;
        }
        return nextValue;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        for (int i = n - 1; i > 0; i--) {
            if (arr[i] <= arr[i - 1]) arr[i - 1] = score(arr[i], arr[i - 1]);
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}