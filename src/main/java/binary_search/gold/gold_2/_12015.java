package binary_search.gold.gold_2;
import java.io.*;
import java.util.StringTokenizer;
public class _12015 {
    static int[] lis;
    static int binarySearch(int left, int right, int num) {
        while(left < right) {
            int mid = (left + right) / 2;

            if(num <= lis[mid]) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        lis = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int index = 1;
        lis[index] = arr[1];

        for(int i = 2; i <= n; i++) {
            if(lis[index] < arr[i]) {
                index++;
                lis[index] = arr[i];
            }
            else {
                int result = binarySearch(1, index, arr[i]);
                lis[result] = arr[i];
            }
        }
        bw.write(String.valueOf(index));
        bw.flush();
        bw.close();
    }
}