package bruteforce.bronze.bronze_3;
import java.io.*;
public class _13225 {
    public static int divisorCount(int num) {
        int count = 0;
        int i = 1;

        while (i <= num) {
            if (num % i == 0)
                count += 1;
            i++;
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];

        for (int i = 1; i < arr.length; i++) {
            int num = Integer.parseInt(br.readLine());
            bw.write(num + " " + divisorCount(num) + "\n");
        }
        bw.flush();
        bw.close();
    }
}