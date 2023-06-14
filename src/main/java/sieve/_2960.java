package sieve;
import java.io.*;
import java.util.StringTokenizer;
public class _2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;

        boolean[] check = new boolean[n + 1];
        check[1] = true;

        for(int i = 2; i <= n; i++) {
            for(int j = i; j <= n; j+=i) {
                if(!check[j]) {
                    check[j] = true;
                    cnt++;
                }
                if(cnt == k) {
                    bw.write(String.valueOf(j));
                    bw.flush();
                    bw.close();
                    System.exit(0);
                }
            }
        }
    }
}