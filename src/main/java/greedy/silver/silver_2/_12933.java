package greedy.silver.silver_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _12933 {

    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input = br.readLine();

        // 녹음한 소리의 길이가 5의 배수가 아니거나, 녹음한 소리의 첫 번째 소리가 q가 아닌 경우
        if (input.length() % 5 != 0 || input.charAt(0) != 'q') {
            bw.write("-1");
        }

        else {
            bw.write(String.valueOf(findDuck()));
        }

        bw.flush();
        bw.close();
    }

    private static int findDuck() {

        int index = 0, answer = 0;

        char[] duck = {'q', 'u', 'a', 'c', 'k'};
        List<Character> list = new ArrayList<>();
        boolean[] visited = new boolean[input.length()];

        for (int i = 0; i < input.length(); i++) {
            if (visited[i]) {
                continue;
            }

            for (int j = 0; j < input.length(); j++) {
                // 방문하지 않고, 오리 울음소리 순서가 일치할 때
                if (!visited[j] && input.charAt(j) == duck[index]) {
                    visited[j] = true;
                    list.add(input.charAt(j));
                    index++;
                }

                if (index == 5) {
                    index = 0;
                }
            }

            if (!list.isEmpty()) {
                /*
                 * 울음소리가 `quack`이 아닌 경우
                 * 예제 6의 경우 `quackquackqu`이 저장된다.
                 */
                if (list.get(list.size() - 1) != 'k') {
                    return -1;
                }

                answer++;
            }
        }

        return answer;
    }

}