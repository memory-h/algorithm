package binary_search.platinum.platinum_5;
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
public class _14003 {
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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] ans = new int[n + 1];
        lis = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int index = 1;
        lis[index] = arr[1];
        ans[1] = index;

        for(int i = 2; i <= n; i++) {
            if(lis[index] < arr[i]) {
                index++;
                lis[index] = arr[i];
                ans[i] = index;
            }
            else {
                int findIndex = binarySearch(1, index, arr[i]);
                lis[findIndex] = arr[i];
                ans[i] = findIndex;
            }
        }
        sb.append(index + "\n");

        Stack<Integer> stack = new Stack<>();
        int tmp = index;

        for(int i = n; i > 0; i--) {
            if(ans[i] == tmp) {
                tmp--;
                stack.push(arr[i]);
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop() + " ");

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}