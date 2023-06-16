package string;
import java.io.*;
public class _2386 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = br.readLine();

            // 입력된 문자열을 첫번째 공백을 기준으로 두 부분으로 나누는데, 이 때 나누어진 부분은 최대 두 개까지만 구분된다.
            String[] splitted = input.split(" ", 2);

            if(splitted[0].equals("#")) break;

            int c = splitted[0].charAt(0);
            String str = splitted[1].toLowerCase();
            int count = 0;

            for(int i = 0; i < str.length(); i++) {
                if(c == str.charAt(i)) count++;
            }
            sb.append((char) c + " " + count + "\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}