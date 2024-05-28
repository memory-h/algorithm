package string.bronze.bronze_3;

import java.io.*;

public class _20540 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String mbti = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < mbti.length(); i++) {
            switch (mbti.charAt(i)) {
                case 'E':
                    sb.append('I');
                    break;

                case 'S':
                    sb.append('N');
                    break;

                case 'T':
                    sb.append('F');
                    break;

                case 'J':
                    sb.append('P');
                    break;

                case 'I':
                    sb.append('E');
                    break;

                case 'N':
                    sb.append('S');
                    break;

                case 'F':
                    sb.append('T');
                    break;

                case 'P':
                    sb.append('J');
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}