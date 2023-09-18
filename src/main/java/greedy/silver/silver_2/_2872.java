package greedy.silver.silver_2;
import java.io.*;
public class _2872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        /*
          1. 가장 큰수는 움직이지 않아도 된다.
          2. 배열의 최대값의 index를 찾고, index를 1씩 감소시켜 arr[index] 값이 1씩 작아지는 수열의 길이를 구하면 된다.
        */

        int[] arr = new int[n];
        int max = n, index = -1, length = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (max == arr[i]) index = i;
        }

        while (index >= 0) {
            if (max - 1 == arr[index]) {
                max--;
                length++;
            }
            index--;
        }

        bw.write(String.valueOf(n - length));
        bw.flush();
        bw.close();
    }
}