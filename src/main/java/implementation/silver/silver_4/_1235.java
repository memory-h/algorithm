package implementation.silver.silver_4;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class _1235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) arr[i] = br.readLine();

        // 중복을 제거하기 위해 Set 사용
        Set<String> set = new HashSet<>();
        int k = 0;

        for (int i = 1; i <= arr[0].length(); i++) {
            for (int j = 0; j < n; j++) {
                // 뒤에서부터 자릿수를 1씩 늘려가면서 set에 저장한다.
                set.add(arr[j].substring(arr[0].length() - i));
            }

            // set의 크기가 학생 수와 같으면 k에 저장하고 반복문을 종료한다.
            if (set.size() == n) {
                k = i;
                break;
            }

            set.clear();
        }

        bw.write(String.valueOf(k));
        bw.flush();
        bw.close();
    }
}