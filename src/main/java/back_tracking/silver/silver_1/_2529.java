package back_tracking.silver.silver_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _2529 {

    static int k;
    static String[] arr;
    static boolean[] visited;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());

        arr = br.readLine().split(" ");
        visited = new boolean[10];
        list = new ArrayList<>();

        dfs(0, "");

        bw.write(list.get(list.size() - 1) + "\n" + list.get(0));
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, String number) {

        if (depth == k + 1) {
            list.add(number);

            return;
        }

        for (int i = 0; i <= 9; i++) {
            // number.charAt(depth - 1)과 현재 숫자를 비교한다.
            if (!visited[i]) {
                if (depth == 0 || compare(Character.getNumericValue(number.charAt(depth - 1)), i, arr[depth - 1])) {
                    visited[i] = true;
                    dfs(depth + 1, number + i);
                    visited[i] = false;
                }

            }
        }

    }

    private static boolean compare(int preValue, int curValue, String s) {

        if (s.equals(">")) {
            return preValue > curValue;
        }

        else {
            return preValue < curValue;
        }

    }

}