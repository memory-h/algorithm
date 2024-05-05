package math.bronze.bronze_1;

import java.io.*;

public class _11179 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력받은 숫자를 2진수로 변환
        String s = Integer.toBinaryString(Integer.parseInt(br.readLine()));

        // 2진수를 뒤집고 다시 10진수로 변환
        int answer = Integer.parseInt(new StringBuilder(s).reverse().toString(), 2);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

}