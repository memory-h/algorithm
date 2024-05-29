package string.bronze.bronze_2;

import java.io.*;

public class _3449 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            String a = br.readLine();
            String b = br.readLine();

            int hammingDistance = calculateHammingDistance(a, b);

            sb.append("Hamming distance is ").append(hammingDistance).append(".\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int calculateHammingDistance(String a, String b) {
        int distance = 0;

        // 해밍 거리를 계산
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                distance++;
            }
        }

        return distance;
    }

}