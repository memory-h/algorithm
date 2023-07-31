package sorting.bronze.bronze_3;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class _28417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int max = -1;

        while(n --> 0) {
            st = new StringTokenizer(br.readLine());

            int[] run = new int[2];
            int[] trick = new int[5];
            int runMax = 0;

            for(int i = 0; i < 2; i++) {
                run[i] = Integer.parseInt(st.nextToken());
                runMax = Math.max(runMax, run[i]);
            }
            for(int i = 0; i < 5; i++) trick[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(trick);

            int trickMax = trick[4];
            int trickSecond = trick[3];
            max = Math.max(max, runMax + trickMax + trickSecond);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}