package greedy.silver.silver_4;
import java.io.*;
import java.util.Arrays;
public class _10610 {
    static int sum = 0;

    private static boolean findNumber(char[] arr) {
        for(char c : arr) {
           sum += c;
        }
        return sum % 3 == 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;

        String n = br.readLine();
        char[] arr = new char[n.length()];

        for(int i = 0; i < n.length(); i++) arr[i] = n.charAt(i);

        Arrays.sort(arr);
        sb = new StringBuilder(new String(arr));

        if(arr[0] == '0' && findNumber(arr)) bw.write(sb.reverse().toString());
        else bw.write("-1");

        bw.flush();
        bw.close();
    }
}