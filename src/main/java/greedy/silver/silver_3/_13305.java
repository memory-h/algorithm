package greedy.silver.silver_3;
import java.io.*;
import java.util.StringTokenizer;
public class _13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] edge = new int[n - 1];
        int[] node = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) edge[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) node[i] = Integer.parseInt(st.nextToken());

        long min = node[0], result = 0L;

        // 현재 도시와 다음 도시의 주유 가격을 비교하면서 더 낮은 가격으로 주유한다.
        for (int i = 0; i < n - 1; i++) {
            result += min * edge[i];

            min = Math.min(min, node[i + 1]);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}