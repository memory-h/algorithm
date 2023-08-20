package greedy.silver.silver_4;
import java.io.*;
import java.util.Arrays;
public class _10610 {
    private static boolean checkNumber(char[] arr) {
        int sum = 0;

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

        // 정렬
        Arrays.sort(arr);
        sb = new StringBuilder(new String(arr));

        // 0번째 index가 0이고, arr 원소를 전부 더했을 때 3으로 나누어 떨어지는지 확인
        if(arr[0] == '0' && checkNumber(arr)) bw.write(sb.reverse().toString());
        else bw.write("-1");

        bw.flush();
        bw.close();
    }
}