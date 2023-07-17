package bruteforce.bronze.bronze_1;
import java.io.*;
public class _10448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        int[] arr = new int[45];

        for(int i = 1; i <= 44; i++) arr[i] = i * (i + 1) / 2;

        while(testCase --> 0) {
            int result = 0;
            int k = Integer.parseInt(br.readLine());

            for(int i = 1; i <= 44; i++) {
                for(int j = 1; j <= 44; j++) {
                    for(int l = 1; l <= 44; l++) {
                        if(arr[i] + arr[j] + arr[l] == k) result = 1;
                    }
                }
            }
            sb.append(result + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}