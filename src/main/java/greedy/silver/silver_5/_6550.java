package greedy.silver.silver_5;
import java.io.*;
import java.util.StringTokenizer;
public class _6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str;

        while((str = br.readLine()) != null) {
            st = new StringTokenizer(str);

            String s = st.nextToken();
            String t = st.nextToken();
            int index = 0;

            for (int i = 0; i < t.length(); i++) {
                if (index == s.length()) break;
                if (s.charAt(index) == t.charAt(i)) index++;
            }
            if (index == s.length()) bw.write("Yes\n");
            else bw.write("No\n");

            bw.flush();
        }
        bw.close();
    }
}