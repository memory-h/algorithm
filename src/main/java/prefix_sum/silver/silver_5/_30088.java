package prefix_sum.silver.silver_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _30088 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[] times = new long[n];
        long[] prefixSum = new long[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int employee = Integer.parseInt(st.nextToken());
            long sum = 0L;

            for (int j = 0; j < employee; j++) {
                sum += Integer.parseInt(st.nextToken());
            }

            times[i] = sum;
        }

        Arrays.sort(times);

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = times[i] + prefixSum[i];
        }

        long result = 0L;

        for (long val : prefixSum) {
            result += val;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//
//        int n = Integer.parseInt(br.readLine());
//        long[] times = new long[n];
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            long employee = Integer.parseInt(st.nextToken());
//            long DepartmentTime = 0;
//
//            for (int j = 0; j < employee; j++) {
//                DepartmentTime += Integer.parseInt(st.nextToken());
//            }
//            times[i] = DepartmentTime;
//        }
//        Arrays.sort(times);
//
//        long[] prefixSum = new long[n + 1];
//        long result = 0;
//
//        for (int i = 0; i < n; i++) {
//            prefixSum[i + 1] = prefixSum[i] + times[i];
//            result += prefixSum[i + 1];
//        }
//
//        bw.write(String.valueOf(result));
//        bw.flush();
//        bw.close();
//    }

}