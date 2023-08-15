package hash_set.silver.silver_4;
import java.io.*;
import java.util.*;
public class _28446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int m = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if(type == 1) {
                int x = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                map.put(w, x);
            }
            else if(type == 2) {
                int w = Integer.parseInt(st.nextToken());

                sb.append(map.get(w) + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}