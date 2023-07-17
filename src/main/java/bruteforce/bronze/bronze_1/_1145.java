package bruteforce.bronze.bronze_1;
import java.io.*;
import java.util.StringTokenizer;
public class _1145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[6];
        int cache = 1;

        for(int i = 1; i <= 5; i++) arr[i] = Integer.parseInt(st.nextToken());

        while(true) {
            int count = 0;

            for(int i = 1; i <= 5; i++) {
                if(cache % arr[i] == 0) count++;
            }
            if(count >= 3) {
                bw.write(String.valueOf(cache));
                break;
            }
            cache++;
        }
        bw.flush();
        bw.close();
    }
}