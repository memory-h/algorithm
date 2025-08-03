package greedy.bronze.bronze_2;

import java.io.*;

public class _5585 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int payment = Integer.parseInt(br.readLine());
        int change = 1000 - payment;

        int[] money = new int[] {500, 100, 50, 10, 5, 1};
        int count = 0;

        for (int m : money) {
            count += change / m;
            change %= m;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

}