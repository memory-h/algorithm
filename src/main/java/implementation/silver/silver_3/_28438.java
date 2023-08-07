package implementation.silver.silver_3;
import java.io.*;
import java.util.StringTokenizer;
public class _28438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[] rowSum = new int[n];
        int[] colSum = new int[m];

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken());

            if(type == 1) rowSum[index] += v;
            else colSum[index] += v;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = rowSum[i] + colSum[j];
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}