package bruteforce.gold.gold_5;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class _1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[10];
        Arrays.fill(check, false);

        if(m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                check[num] = true;
            }
        }
        int minCount = Math.abs(n - 100);

        for(int i = 0; i < 1000000; i++) {
            String str = String.valueOf(i);
            int strLength = str.length();

            boolean button = true;
            for(int j = 0; j < str.length(); j++) {
                if(check[str.charAt(j) - '0']) {
                    button = false;
                    break;
                }
            }
            if(button) minCount = Math.min(minCount, Math.abs(n - i) + strLength);
        }
        bw.write(String.valueOf(minCount));
        bw.flush();
        bw.close();
    }
}