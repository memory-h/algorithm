package back_tracking.silver.silver_3;
import java.io.*;
public class _2992 {
    static int n, strNumber, min = Integer.MAX_VALUE;
    static int[] arr, list;
    static boolean[] visited;

    private static void backtracking(int depth) {
        if(depth == n) {
            String str = "";
            for(int num : list) str += num;

            if(strNumber < Integer.parseInt(str)) min = Math.min(min, Integer.parseInt(str));
            return;
        }
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;

            list[depth] = arr[i];
            visited[i] = true;
            backtracking(depth + 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        strNumber = Integer.parseInt(str);
        n = str.length();

        arr = new int[n];
        list = new int[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(str.split("")[i]);

        backtracking(0);

        if(min == Integer.MAX_VALUE) min = 0;

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}