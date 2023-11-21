package greedy.gold.gold_3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int min = 50;
        int index = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }
        int m = Integer.parseInt(br.readLine());
        int count = 0;

        // 비용이 가장 작은 최대 자릿수를 찾는다.
        while (m >= min) {
            m -= min;
            count++;
        }

        // 방 번호를 저장할 배열 선언 및 index 값으로 초기화
        int[] result = new int[count];
        Arrays.fill(result, index);

        int resultIndex = 0;

        for (int i = 0; i < count; i++) {
            for (int j = n - 1; j >= 0; j--) {
                // 방 번호를 갱신할 때, m이 (arr[j] - min) 보다 크거나 같으면 m에서 빼고 인덱스를 저장한다.
                if (m - (arr[j] - min) >= 0) {
                    m -= arr[j] - min;
                    result[i] = j;

                    break;
                }
            }
            /*
             result[resultIndex]가 0이면, 현재 돈으로 숫자를 구매할 수 없다.
             따라서 자릿수를 1개 줄이고, min의 비용을 m에 추가해 준다.
             */
            if (result[resultIndex] == 0) {
                resultIndex++;
                m += min;
            }
        }
        // 모든 방 번호가 0 일 때
        if (resultIndex == count) bw.write("0");

        else {
            StringBuilder sb = new StringBuilder();

            for (int i = resultIndex; i < count; i++)
                sb.append(result[i]);

            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
    }
}