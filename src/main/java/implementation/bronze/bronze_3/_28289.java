package implementation.bronze.bronze_3;
import java.io.*;
import java.util.StringTokenizer;
public class _28289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int noting = 0, soft = 0, embedded = 0, ai = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int year = Integer.parseInt(st.nextToken());
            int group = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(year == 1) noting++;
            if(year >= 2) {
                if(group == 1 || group == 2) soft++;
                if(group == 3) embedded++;
                if(group == 4) ai++;
            }
        }
        String result = soft + "\n" + embedded + "\n" + ai + "\n" + noting;

        bw.write(result);
        bw.flush();
        bw.close();
    }
}