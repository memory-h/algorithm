package greedy.silver.silver_3;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class _28353 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[n];
        boolean[] check = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            check[i] = false;
        }
        int count = 0;
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!check[i] && !check[j] && arr[i] + arr[j] <= k) {
                    count++;
                    check[i] = check[j] = true;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}