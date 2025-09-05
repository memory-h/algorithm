package greedy.silver.silver_5;

import java.io.*;

public class _15904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        char[] ucpc = new char[] {'U', 'C', 'P', 'C'};
        int ucpcIndex = 0;
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (ucpc[ucpcIndex] == str.charAt(i)) {
                ucpcIndex++;
                count++;
            }
            if (ucpcIndex == ucpc.length || count == ucpc.length) {
                break;
            }
        }

        bw.write(count == 4 ? "I love UCPC" : "I hate UCPC");
        bw.flush();
        bw.close();
    }

}