package hash_set.silver.silver_5;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String s = st.nextToken();

        String[] arr = new String[n];

        // HashSet을 사용해 중복된 이름을 걸러낸다.
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            set.add(arr[i]);
        }

        /*
          윷놀이, 같은 그림 찾기, 원카드는 각각 2, 3, 4명이서 플레이하는 게임이고, 임스는 항상 게임에 참여하므로
          다음과 같이 임스가 최대로 몇 번이나 게임을 플레이할 수 있는지 구할 수 있다.
         */
        if (s.equals("Y")) bw.write(String.valueOf(set.size()));
        else if (s.equals("F")) bw.write(String.valueOf(set.size() / 2));
        else bw.write(String.valueOf(set.size() / 3));

        bw.flush();
        bw.close();
    }
}