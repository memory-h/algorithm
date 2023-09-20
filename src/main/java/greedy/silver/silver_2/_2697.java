package greedy.silver.silver_2;

import java.io.*;

public class _2697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            String input = br.readLine();
            int length = input.length();
            String result = "";

            int[] arr = new int[10];

            // 뒤에서 부터 내림차순이 시작되는 지점을 찾는다.
            for (int i = length - 1; i > 0; i--) {
                if (input.charAt(i) > input.charAt(i - 1)) {
                    for (int j = i - 1; j < length; j++) arr[input.charAt(j) - '0']++;

                    // 0 부터 (i - 1) 지점까지 넣어준다.
                    sb.append(input, 0, i - 1);

                    // 해당 지점보다 크면서 가장 작은 수를 찾는다.
                    for (int j = input.charAt(i - 1) - '0' + 1; j < 10; j++) {
                        if (arr[j] > 0) {
                            arr[j]--;
                            result += j;
                            break;
                        }
                    }

                    // 나머지 수들을 오름차순 정렬한다.
                    for (int j = 0; j < 10; j++) {
                        while (arr[j] --> 0) result += j;
                    }

                    sb.append(result + "\n");
                    break;
                }
            }
            if (result.isEmpty()) sb.append("BIGGEST\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}