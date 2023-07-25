package bruteforce.silver.silver_4;
import java.io.*;
import java.util.StringTokenizer;
public class _2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int left = 0, right = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int sum = arr[0], count = 0;

        while(left < arr.length) {
            if(sum < m && right + 1 < arr.length) sum += arr[++right];
            else {
                if(sum == m) count++;
                sum -= arr[left++];
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}