package sprague_grundy.platinum.platinum_4;

import java.io.*;
import java.util.StringTokenizer;

public class _16895 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

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
            for (int i = 0; i < n; i++) {
                if ((grundy ^ arr[i]) <= arr[i]) count++;
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}