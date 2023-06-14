package math;
import java.io.*;
public class _12871 { // 문자열 크기 제한이 50이라 최소공배수로 푸는 것이 가능함.
    public static int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }
    public static int GCD(int a, int b) {
        while(b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();
        String fs = s;
        String ft = t;

        if(s.length() != t.length()) {
            int length = LCM(s.length(), t.length());

            while(fs.length() != length) fs += s;
            while (ft.length() != length) ft += t;
        }
        if(fs.equals(ft)) bw.write(String.valueOf(1));
        else bw.write(String.valueOf(0));

        bw.flush();
        bw.close();
    }
}