package string.silver.silver_5;

import java.io.*;

public class _11536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        // 배열이 오름차순으로 정렬되어 있는지 확인
        if (isSortedIncreasing(arr)) {
            bw.write("INCREASING");
        }

        // 배열이 내림차순으로 정렬되어 있는지 확인
        else if (isSortedDecreasing(arr)) {
            bw.write("DECREASING");
        }

        // 둘 다 아닐 경우
        else {
            bw.write("NEITHER");
        }

        bw.flush();
        bw.close();
    }

    // 배열이 오름차순으로 정렬되어 있는지 확인
    private static boolean isSortedIncreasing(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    // 배열이 내림차순으로 정렬되어 있는지 확인
    private static boolean isSortedDecreasing(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) < 0) {
                return false;
            }
        }
        return true;
    }

}