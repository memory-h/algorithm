package bruteforce.silver.silver_4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _1544 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<String> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (arr.isEmpty()) arr.add(input);

            List<String> list = new ArrayList<>();

            // 입력된 단어로 만들 수 있는 모든 사이클 단어를 만든다.
            for (int j = 0; j < input.length(); j++)
                list.add(input.substring(j) + input.substring(0, j));

            boolean check = true;

            // 서로 다른 단어가 몇 개인지 구한다.
            for (String string : arr) {
                for (String s : list) {
                    if (string.equals(s)) {
                        check = false;
                        break;
                    }
                }
            }

            if (check) arr.add(input);
        }

        bw.write(String.valueOf(arr.size()));
        bw.flush();
        bw.close();
    }
}