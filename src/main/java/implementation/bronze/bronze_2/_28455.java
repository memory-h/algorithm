package implementation.bronze.bronze_2;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
public class _28455 {
    private static int union(int level) {
        if(level >= 250) return 5;
        else if(level >= 200) return 4;
        else if(level >= 140) return 3;
        else if(level >= 100) return 2;
        else if(level >= 60) return 1;
        else return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];
        int sum = 0, ability = 0;

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr, Collections.reverseOrder());

        for(int i = 0; i < Math.min(n, 42); i++) {
            sum += arr[i];
            ability += union(arr[i]);

        }
        bw.write(sum + " " + ability);
        bw.flush();
        bw.close();
    }
}