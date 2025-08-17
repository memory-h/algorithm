package greedy.bronze.bronze_1;

import java.io.*;

public class _15881 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String obj = br.readLine();

        String ppap = "pPAp";
        int ppapCount = 0;

        for (int i = 0; i <= n - 4; i++) {
            if (obj.substring(i, i + 4).equals(ppap)) {
                i += 3;
                ppapCount++;
            }
        }

        bw.write(String.valueOf(ppapCount));
        bw.flush();
        bw.close();
    }

}