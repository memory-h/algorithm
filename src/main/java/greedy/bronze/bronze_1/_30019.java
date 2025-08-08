package greedy.bronze.bronze_1;

import java.io.*;
import java.util.StringTokenizer;

public class _30019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] lectureRooms = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (lectureRooms[k] <= s) {
                lectureRooms[k] = e;
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}