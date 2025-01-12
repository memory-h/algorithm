package prefix_sum.silver.silver_5;

import java.io.*;

public class _11059 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String creepyStr = br.readLine();
        int[] arr = new int[creepyStr.length()];

        for (int i = 0; i < creepyStr.length(); i++) {
            arr[i] = creepyStr.charAt(i) - '0';
        }

        int[] prefixSum = new int[creepyStr.length() + 1];

        for (int i = 0; i < creepyStr.length(); i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        int result = findCreepyStrLength(creepyStr, prefixSum);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int findCreepyStrLength(String creepyStr, int[] prefixSum) {
        int maxCreepyStrLength = 0;

        for (int len = 2; len <= creepyStr.length(); len+=2) {
            for (int i = 0; i <= creepyStr.length() - len; i++) {
                int leftSum = prefixSum[len / 2 + i] - prefixSum[i];
                int rightSum = prefixSum[len + i] - prefixSum[len / 2 + i];

                if (leftSum == rightSum) {
                    maxCreepyStrLength = len;
                    break;
                }
            }
        }
        return maxCreepyStrLength;
    }

}