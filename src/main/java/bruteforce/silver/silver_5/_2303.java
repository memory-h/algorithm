package bruteforce.silver.silver_5;
import java.io.*;
import java.util.StringTokenizer;
public class _2303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int index = 0;

        while(n --> 0) {
            st = new StringTokenizer(br.readLine());
            int[] number = new int[5];
            int max = 0;

            for(int i = 0; i < 5; i++) number[i] = Integer.parseInt(st.nextToken());

            for(int i = 0; i < 3; i++) {
                for(int j = i + 1; j < 4; j++) {
                    for(int k = j + 1; k < 5; k++) {
                        int sum = number[i] + number[j] + number[k];
                        max = Math.max(max, sum % 10);
                    }
                }
            }
            arr[index] = max;
            index++;
        }
        int resultMax = -1; int resultIndex = 0;

        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] > resultMax) {
                resultMax = arr[i];
                resultIndex = i + 1;
            }
        }
        bw.write(String.valueOf(resultIndex));
        bw.flush();
        bw.close();
    }
}