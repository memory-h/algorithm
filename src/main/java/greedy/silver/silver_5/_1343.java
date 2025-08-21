package greedy.silver.silver_5;

import java.io.*;

public class _1343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String board = br.readLine();
        String polyominoA = "AAAA";
        String polyominoB = "BB";

        board = board.replaceAll("XXXX", polyominoA);
        board = board.replaceAll("XX", polyominoB);

        if (board.contains("X")) {
            bw.write("-1");
        } else {
            bw.write(board);
        }

        bw.flush();
        bw.close();
    }

}
// replaceAll() : 대상 문자열을 원하는 문자 값으로 변환하는 함수이다.
// 첫번째 매개변수는 변환하고자 하는 대상이 될 문자열
// 두번째 매개변수는 변환할 문자 값