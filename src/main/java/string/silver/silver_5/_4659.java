package string.silver.silver_5;
import java.io.*;
public class _4659 {
    public static boolean isAcceptable(String str) {
        boolean check = false;
        int cstVowels = 0; // 연속 모음
        int cstConsonants = 0; // 연속 자음

        char cstChar = '0';

        for(char c : str.toCharArray()) {
            // 모음을 찾았을 때
            if("aeiou".indexOf(c) != -1) {
                check = true;
                cstVowels++;
                cstConsonants = 0;

                if(cstVowels >= 3) return false;
            }
            // 자음을 찾았을 때
            else {
                cstConsonants++;
                cstVowels = 0;

                if(cstConsonants >= 3) return false;
            }
            // 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용
            if(c == cstChar && c != 'e' && c != 'o') return false;

            cstChar = c;
        }
        return check;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String str = br.readLine();
            if(str.equals("end")) break;

            if(isAcceptable(str)) bw.write("<" + str + "> is acceptable.\n");
            else bw.write("<" + str + "> is not acceptable.\n");
        }
        bw.flush();
        bw.close();
    }
}