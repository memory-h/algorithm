package sprague_grundy.platinum.platinum_4;

import java.io.*;
import java.util.StringTokenizer;

public class _11869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int m = Integer.parseInt(br.readLine());
        int grundy = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int value = Integer.parseInt(st.nextToken());

            /*
             각 칸마다 동전의 개수를 XOR 하여 값을 구한다.
             (여러 게임을 동시에 진행하는 경우의 그런디 넘버는 각 게임판의 그런디 넘버를 XOR 한 값과 같다.)
             */
            grundy ^= value;
        }

        // grundy가 0이 아니면 koosaga 승리
        if (grundy != 0) bw.write("koosaga");

        // grundy가 0이면 cubelover 승리
        else bw.write("cubelover");

        bw.flush();
        bw.close();
    }
}