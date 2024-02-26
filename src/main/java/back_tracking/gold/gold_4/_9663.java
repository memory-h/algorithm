package back_tracking.gold.gold_4;

import java.io.*;

public class _9663 {
    private static int[] arr;
    private static int n, count = 0;

    private static void backtracking(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;

            if(nQueen(depth)) backtracking(depth + 1);
        }
    }

    private static boolean nQueen(int column) {

        for (int i = 0; i < column; i++) {
            if (arr[column] == arr[i]) {
                return false;
            }
            else if (Math.abs(column - i) == Math.abs(arr[column] - arr[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        backtracking(0);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}