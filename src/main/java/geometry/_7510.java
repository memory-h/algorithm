package geometry;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class _7510 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[3];
        int cnt = 0;

        while(n -- > 0) {
            cnt++;
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);

            if(Math.pow(arr[2], 2) == Math.pow(arr[1], 2) + Math.pow(arr[0], 2)) sb.append("Scenario #" + cnt + ":" +"\nyes\n\n");
            else sb.append("Scenario #" + cnt + ":" +"\nno\n\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}