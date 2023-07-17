package bruteforce.bronze.bronze_1;
import java.io.*;
import java.util.Arrays;
public class _2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[10];
        int sum = 0; int find1 = 0, find2 = 0;

        for(int i = 1; i <= 9; i++) sum += arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        for(int i = 1; i <= 8; i++) {
            for(int j = i + 1; j <= 9; j++) {
                if(arr[i] + arr[j] == sum - 100) {
                    find1 = i;
                    find2 = j;
                }
            }
        }
        for(int i = 1; i <= 9; i++) {
            if(find1 == i || find2 == i) continue;

            sb.append(arr[i] + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}