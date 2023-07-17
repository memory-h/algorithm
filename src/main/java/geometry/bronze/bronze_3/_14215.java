package geometry.bronze.bronze_3;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class _14215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];

        for(int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        if(arr[0] == arr[1] && arr[1] == arr[2]) bw.write(String.valueOf(arr[0] + arr[1] + arr[2]));
        else if(arr[0] + arr[1] <= arr[2]) {
            arr[2] = arr[0] + arr[1] - 1;
            bw.write(String.valueOf(arr[0] + arr[1] + arr[2]));
        }
        else bw.write(String.valueOf(arr[0] + arr[1] + arr[2]));

        bw.flush();
        bw.close();
    }
}