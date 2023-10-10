package greedy.bronze.bronze_1;

import java.io.*;

public class _15881 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        String str = "pPAp";
        int count = 0;

        // substring() 메소드를 사용하여 펜-파인애플-애플-펜의 최대 개수를 구한다.
        for (int i = 0; i <= input.length() - 4; i++) {
            if (input.substring(i, i + 4).equals(str)) {
                i += 3;
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}