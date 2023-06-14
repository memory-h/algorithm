package bruteforce;
import java.io.*;
import java.util.StringTokenizer;
public class _7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] weight = new int[n + 1];
        int[] height = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= n; i++) {
            int count = 0;

            for(int j = 1; j <= n; j++) {
                if(weight[j] > weight[i] && height[j] > height[i]) count++;
            }
            sb.append(count + 1 + " ");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}