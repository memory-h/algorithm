package greedy.gold.gold_5;

import java.io.*;

public class _2195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String p = br.readLine();

        int count = 0;
        int pIndex = 0;

        while (pIndex < p.length()) {
            int maxIndex = 0;

            for (int i = 0; i < s.length(); i++) {
                // p.charAt(pIndex)으로 시작하는 문자를 찾으면
                if (p.charAt(pIndex) == s.charAt(i)) {
                    // 인덱스 값을 저장한다.
                    int tempIndex = pIndex;

                    // copy 함수를 최소로 사용하기 위해 copy 함수가 처리할 수 있는 최대 길이 문자열을 찾는다.
                    for (int j = i; j < s.length(); j++) {
                        if (p.charAt(tempIndex) != s.charAt(j)) break;
                        tempIndex++;

                        if (tempIndex == p.length()) break;
                    }
                    maxIndex = Math.max(maxIndex, tempIndex);
                }
            }
            pIndex = maxIndex;
            count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
/*
  반례 :
  aababcefcefd
  aabcefd
 */