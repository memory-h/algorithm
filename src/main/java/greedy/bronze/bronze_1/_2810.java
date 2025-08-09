package greedy.bronze.bronze_1;

import java.io.*;

public class _2810 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String seats = br.readLine();

        int coupleSeatsCount = 0;

        for (int i = 0; i < n - 1; i++) {
            if (seats.charAt(i) == 'L' && seats.charAt(i + 1) == 'L') {
                coupleSeatsCount++;
                i++;
            }
        }

        int cupHolders = n + 1 - coupleSeatsCount;

        bw.write(String.valueOf(Math.min(cupHolders, n)));
        bw.flush();
        bw.close();
    }

}