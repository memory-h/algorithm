package bruteforce;
import java.io.*;
import java.util.StringTokenizer;
public class _1773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[c + 1];
        int count = 0;

        while(n --> 0) {
            int input = Integer.parseInt(br.readLine());

            for(int i = input; i <= c; i+=input) check[i] = true;
        }
        for(int i = 1; i <= c; i++) {
            if(check[i]) count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}