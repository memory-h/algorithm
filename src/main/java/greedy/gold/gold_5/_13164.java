package greedy.gold.gold_5;

import java.io.*;
import java.util.*;

public class _13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        // 인접한 원생들의 키를 빼서 List에 저장한다. (n - 1) 개
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) list.add(arr[i] - arr[i - 1]);

        Collections.sort(list);
        int result = 0;

        /*
         (k - 1) 개수로 k개의 조를 만들 수 있고, 인접한 원생들의 키를 뺀 값의 개수가 (n - 1)이므로
         (n - 1 - (k - 1))까지 값을 더해주면 k개의 조에 대해 티셔츠 만드는 비용의 합의 최소를 구할 수 있다.
         */
        for (int i = 0; i < n - k; i++) result += list.get(i);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}