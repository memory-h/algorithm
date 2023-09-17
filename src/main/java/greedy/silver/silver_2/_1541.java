package greedy.silver.silver_2;
import java.io.*;
public class _1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // "-" 기준으로 분리하여 계산하면 합의 최소가 된다.
        String[] str = br.readLine().split("-");

        int result = 0;

        for (int i = 0; i < str.length; i++) {
            int sum = 0;
            String[] arr = str[i].split("\\+");

            for (String s : arr) {
                sum += Integer.parseInt(s);
            }

            if (i == 0) result += sum;
            else result -= sum;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}