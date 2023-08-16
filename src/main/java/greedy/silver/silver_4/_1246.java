package greedy.silver.silver_4;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class _1246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];

        for(int i = 0; i < m; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int price = 0, max = 0;

        for(int i = 0; i < m; i++) {
            int count = 0;

            for(int j = 0; j < m && count < n; j++) {
                if(arr[j] >= arr[i]) count++;
            }
            if(arr[i] * count > max) {
                max = arr[i] * count;
                price = arr[i];
            }
        }
        bw.write(price + " " + max);
        bw.flush();
        bw.close();
    }
}