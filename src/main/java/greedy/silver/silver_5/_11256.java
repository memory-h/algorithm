package greedy.silver.silver_5;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class _11256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while(testCase --> 0) {
            st = new StringTokenizer(br.readLine());

            int candy = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                arr[i] = r * c;
            }
            Arrays.sort(arr, Collections.reverseOrder());
            int count = 0;

            for(int i = 0; i < n; i++) {
                if(candy <= 0) break;
                candy -= arr[i];
                count++;
            }
            sb.append(count + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}