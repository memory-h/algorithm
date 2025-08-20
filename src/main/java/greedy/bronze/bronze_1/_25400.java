package greedy.bronze.bronze_1;

import java.io.*;
import java.util.StringTokenizer;

public class _25400 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int deleteCardCount = 0;
        int curInPlaceCard = 1;

        for (int i = 0; i < n; i++) {
            if (curInPlaceCard == arr[i]) {
                curInPlaceCard++;
            } else {
                deleteCardCount++;
            }
        }

        bw.write(String.valueOf(deleteCardCount));
        bw.flush();
        bw.close();
    }

}