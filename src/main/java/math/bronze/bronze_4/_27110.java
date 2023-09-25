package math.bronze.bronze_4;

import java.io.*;
import java.util.StringTokenizer;

public class _27110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[3];

        int sum = 0;

        st =  new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] < n) sum += arr[i];
            else sum += n;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}