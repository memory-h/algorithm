package implementation.bronze.bronze_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class _27736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        int people = n / 2;
        int zero = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if(arr[i] == 0) zero++;
            sum += arr[i];
        }
        if(n % 2 != 0) people++;

        if(zero >= people) System.out.println("INVALID");
        else if(sum > 0) System.out.println("APPROVED");
        else  System.out.println("REJECTED");
    }
}