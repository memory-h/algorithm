package string.silver.silver_5;
import java.io.*;
public class _1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int rowCount = 0, columnCount = 0;
        int row = 0, column = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // 가로
                if(arr[i][j] == '.') row++;
                if(arr[i][j] == 'X' || j == n - 1) {
                    if(row >= 2) rowCount++;
                    row = 0;
                }
                // 세로
                if(arr[j][i] == '.') column++;
                if(arr[j][i] =='X' || j == n - 1){
                    if(column >= 2) columnCount++;
                    column = 0;
                }
            }
        }
        bw.write(rowCount + " " + columnCount);
        bw.flush();
        bw.close();
    }
}