package greedy.silver.silver_4;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class _14469 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken()); // 도착 시간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 검문 시간
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0])); // 정렬

        int result = 0;

        for(int i = 0; i < n; i++) {
            // 입장 시간보다 현재 도착 시간이 더 크면 갱신
            if(result < arr[i][0]) result = arr[i][0] + arr[i][1];

            // 아니면 검문 시간 추가
            else result += arr[i][1];
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}