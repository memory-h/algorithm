package greedy.silver.silver_3;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class _20186 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        boolean[] check = new boolean[n];

        // 정렬 후 배열의 맨 뒤 index부터 k만큼 선택한다.
        for (int i = n - 1; i >= 0; i--) {
            if (k > 0) {
                check[i] = true;
                k--;
            }
        }
        int result = 0;

        for (int i = 0; i < n; i++) {
            // 선택되어 있으면, 자신의 왼쪽에 있는 수 중 선택된 수의 개수를 찾는다.
            if (check[i]) {
                int count = 0;

                for (int j = 0; j < i; j++) {
                    if (check[j]) count++;
                }
                // (자신의 수 - 자신의 왼쪽에 있는 수 중 선택된 수의 개수)를 result에 더해준다.
                result += arr[i] - count;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}