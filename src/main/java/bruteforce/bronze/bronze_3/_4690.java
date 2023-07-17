package bruteforce.bronze.bronze_3;
import java.io.*;
public class _4690 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int a = 2; a <= 100; a++) {
            for(int b = 2; b <= a; b++) {
                for(int c = b; c <= a; c++) {
                    for(int d = c; d <= a; d++) {
                        if(a * a * a == b * b * b + c * c * c + d * d * d)
                        //if(Math.pow(a, 3) == Math.pow(b, 3) + Math.pow(c, 3) + Math.pow(d, 3))  -> 속도가 더 느림
                            sb.append("Cube = " + a + ", Triple = (" + b + "," + c + "," + d + ")" + "\n");
                    }
                }
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}