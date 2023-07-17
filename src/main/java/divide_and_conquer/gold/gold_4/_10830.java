package divide_and_conquer.gold.gold_4;
import java.io.*;
import java.util.StringTokenizer;
public class _10830 {
    static int N;
    static final int fisano = 1000;
    public static int[][] power(int[][] a, long n) {
        if(n == 1L) return a;

        int[][] ret = power(a, n / 2);
        ret = multiply(ret, ret);

        if(n % 2 == 1L) ret = multiply(ret, a);

        return ret;
    }
    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] multi = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    multi[i][j] += (a[i][k] * b[k][j]) % fisano;
                }
            }
        }
        return multi;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % fisano;
            }
        }
        int[][] result = power(arr, B);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                bw.write(result[i][j] % fisano + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        System.out.println(bw);
    }
}