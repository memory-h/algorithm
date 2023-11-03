package string.silver.silver_4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        List<String> list = new ArrayList<>();

        // List에 문자열 S의 접미사를 담는다.
        for (int i = 0; i < s.length(); i++)
            list.add(s.substring(i, s.length()));

        // 사전순으로 정렬
        Collections.sort(list);

        // StringBuilder를 사용하여 문자열 S의 접미사를 사전순으로 출력한다.
        for (String str : list)
            sb.append(str + "\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}