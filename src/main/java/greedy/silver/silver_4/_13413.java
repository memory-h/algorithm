package greedy.silver.silver_4;
import java.io.*;
public class _13413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            int n = Integer.parseInt(br.readLine());

            char[] c1 = br.readLine().toCharArray();
            char[] c2 = br.readLine().toCharArray();

            int countB = 0, countW = 0;

            // 검은색, 흰색의 개수를 각각 구해서 푼다.
            for (int i = 0; i < n; i++) {
                if (c1[i] == 'B' &&  c2[i] == 'W') countB++;
                else if(c1[i] == 'W' &&  c2[i] == 'B') countW++;
            }
            sb.append(Math.max(countB, countW) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}