package greedy.gold.gold_4;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
public class _1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[26];
        Arrays.fill(arr, 0);

        for(int i = 0; i < n; i++) {
            char[] c = br.readLine().toCharArray();

            // 각 문자마다 위치한 수의 자리에 따라 가중치를 정해서 더해준다.
            for(int j = 0; j < c.length; j++) {
                arr[c[j] - 'A'] += (int) Math.pow(10, c.length - j - 1);
            }
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int result = 0, number = 9;

        for(int i = 0; i < 26; i++) {
            if(arr[i] == 0) break;

            result += arr[i] * number;
            number--;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}