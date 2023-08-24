package bruteforce.silver.silver_3;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class _10655 {
    static List<Integer> x;
    static List<Integer> y;

    private static int manhattanDistance(int i, int j) {
        return Math.abs(x.get(i) - x.get(j)) + Math.abs(y.get(i) - y.get(j));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        x = new ArrayList<>();
        y = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            x.add(Integer.parseInt(st.nextToken()));
            y.add(Integer.parseInt(st.nextToken()));
        }

        // 전체 체크포인트 거리의 합
        int sum = 0;
        for(int i = 0; i < n - 1; i++) sum += manhattanDistance(i, i + 1);

        // 체크포인트를 건너뛰어서 최소 거리를 각각의 경우에서 거리를 계산하고 그중 최솟값을 찾는다.
        int result = sum;
        for(int i = 1; i < n - 1; i++) {
            int distance = sum - (manhattanDistance(i, i - 1) + manhattanDistance(i, i + 1))
                    + manhattanDistance(i - 1, i + 1);

            result = Math.min(result, distance);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}