package greedy.silver.silver_4;
import java.io.*;
import java.util.StringTokenizer;
public class _12782 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            st = new StringTokenizer(br.readLine());

            char[] c1 = st.nextToken().toCharArray();
            char[] c2 = st.nextToken().toCharArray();

            int countZero = 0, countOne = 0;

            // 0과 1의 개수를 각각 구해서 푼다.
            for(int i = 0; i < c1.length; i++) {
                if(c1[i] == '0' && c2[i] == '1') countZero++;
                else if(c1[i] == '1' && c2[i] == '0') countOne++;
            }
            sb.append(Math.max(countZero, countOne) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}