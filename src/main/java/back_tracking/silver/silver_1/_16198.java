package back_tracking.silver.silver_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _16198 {

    static int n, max = Integer.MIN_VALUE;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        dfs(0, 0);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int curEnergy) {

        if (depth == n - 2) {
            max = Math.max(max, curEnergy);

            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int temp = list.get(i);
            int energy = list.get(i - 1) * list.get(i + 1); // Wx-1 × Wx+1의 에너지

            list.remove(i); // i번째 에너지 제거

            dfs(depth + 1, curEnergy + energy);

            list.add(i, temp); // i번째 위치에 temp 에너지 저장
        }

    }

}