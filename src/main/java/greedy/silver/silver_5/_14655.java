package greedy.silver.silver_5;

import java.io.*;
import java.util.StringTokenizer;

public class _14655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] frontSide = new int[n];
        int[] backSide = new int[n];
        int result = 0;

        // 동전의 앞면과 뒷면을 각각 절댓값으로 입력받고 더해주면 답을 구할 수 있다.

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) frontSide[i] = Math.abs(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) backSide[i] = Math.abs(Integer.parseInt(st.nextToken()));

        for (int i = 0; i < n; i++) result += frontSide[i] + backSide[i];

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}