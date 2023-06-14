package string;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class _1380 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list;
        StringTokenizer st;

        String[] name;
        int cnt = 1;

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if(N == 0) break;
            name = new String[N];

            for(int i = 0; i < N; i++) {
                name[i] = br.readLine();
            }
            list = new ArrayList<>();
            for(int i = 0; i < 2 * N - 1; i++) {
                st = new StringTokenizer(br.readLine());

                int num = Integer.parseInt(st.nextToken());

                if(list.contains(num)) list.remove((Integer)num);
                else list.add(num);
            }
            int resultNum = list.get(0);
            System.out.println(cnt + " " + name[resultNum - 1]);
            cnt++;
        }
    }
}