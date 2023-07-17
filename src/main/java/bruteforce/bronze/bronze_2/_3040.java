package bruteforce.bronze.bronze_2;
import java.io.*;
public class _3040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        boolean[] check = new boolean[9];
        int[] arr = new int[9];
        int sum = 0;

        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            check[i] = true;
            sum += arr[i];
        }

        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(arr[i] + arr[j] == sum - 100) {
                    check[i] = false;
                    check[j] = false;
                }
            }
        }
        for(int i = 0; i < 9; i++) {
            if(check[i]) sb.append(arr[i] + "\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}