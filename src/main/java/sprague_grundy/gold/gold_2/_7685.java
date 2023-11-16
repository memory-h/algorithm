package sprague_grundy.gold.gold_2;

import java.io.*;
import java.util.StringTokenizer;

public class _7685 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            int[] arr = new int[n];
            int grundy = 0;
            int count = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

                grundy ^= arr[i];
            }

            if (grundy == 0) sb.append(0 + "\n");
            else {
                /*
                 i번째 돌무더기를 제외한 나머지 모든 돌무더기를 XOR 해준다.
                 0 XOR temp부터 (arr[i] - 1) XOR temp 중에서 0이 될 수 있는 것을 찾는다.
                 */
                for (int i = 0; i < n; i++) {
                    int temp = 0;

                    for (int j = 0; j < n; j++) {
                        if (i == j) continue;

                        temp ^= arr[j];
                    }
                    if (temp <= arr[i]) count++;
                }
                sb.append(count).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}