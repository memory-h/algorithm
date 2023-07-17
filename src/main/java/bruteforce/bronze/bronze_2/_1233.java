package bruteforce.bronze.bronze_2;
import java.io.*;
import java.util.StringTokenizer;
public class _1233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int s3 = Integer.parseInt(st.nextToken());

        int[] arr = new int[81];
        int max = Integer.MIN_VALUE;
        int result = 0;

        for(int i = 1; i <= s1; i++) {
            for(int j = 1; j <= s2; j++) {
                for(int k = 1; k <= s3; k++) {
                    arr[i + j + k]++;
                }
            }
        }
        for(int i = 3; i <= 60; i++) {
            if(arr[i] > max) result = i;
            max = Math.max(max, arr[i]);
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}