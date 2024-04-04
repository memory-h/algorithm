package math.bronze.bronze_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == -1) {
                break;
            }

            List<Integer> list = new ArrayList<>();
            int sum = 0; // 약수의 합을 저장

            for (int i = 1; i < n; i++) {
                // n의 약수인 경우 sum에 i를 더하고, List에 저장한다.
                if (n % i == 0) {
                    list.add(i);
                    sum += i;
                }
            }

            sb.append(n);

            // 완전수가 아닌 경우
            if (sum != n) {
                sb.append(" is NOT perfect.\n");
            } else { // 완전수인 경우
                sb.append(" = ");

                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - 1) {
                        sb.append(list.get(i)).append("\n");
                    } else {
                        sb.append(list.get(i)).append(" + ");
                    }
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}