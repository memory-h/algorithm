package bruteforce;
import java.io.*;
public class _2160 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][][] arr = new int[n][5][7];
        int count; int min = Integer.MAX_VALUE;
        String result = "";

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 5; j++) {
                String str = br.readLine();

                for(int k = 0; k < 7; k++) {
                    arr[i][j][k] = str.charAt(k);
                }
            }
        }
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                count = 0;
                for(int k = 0; k < 5; k++) {
                    for(int l = 0; l < 7; l++) {
                        if(arr[i][k][l] != arr[j][k][l]) count++;
                    }
                }
                if(min > count) {
                    min = count;
                    result = (i + 1) + " " + (j + 1);
                }
            }
        }
        bw.write(result);
        bw.flush();
        bw.close();
    }
}