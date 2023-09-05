package greedy.silver.silver_3;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class _5545 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 토핑의 종류 수

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 도우 가격
        int b = Integer.parseInt(st.nextToken()); // 토핑 가격

        int c = Integer.parseInt(br.readLine()); // 도우의 열량

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr, Collections.reverseOrder());

        int sum = c;

        // 토핑을 선택하지 않았을 때
        int result = c / a, topping = 0;

        // 토핑을 추가하면서 최고의 피자의 1원당 열량을 구한다.
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            topping++;

            if (sum / (a + b * topping) >= result) result = sum / (a + b * topping);
            // 낮아진다면 바로 그전의 열량이 최대이므로 break
            else break;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}