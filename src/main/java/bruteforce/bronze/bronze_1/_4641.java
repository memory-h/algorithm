package bruteforce.bronze.bronze_1;
import java.io.*;
import java.util.StringTokenizer;
public class _4641 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            int index = 0; int count = 0;
            int[] arr = new int[st.countTokens()];

            while(st.hasMoreTokens()) {
                if(index <= arr.length) {
                    arr[index] = Integer.parseInt(st.nextToken());
                    index++;
                }
            }
            if(arr[0] == -1) break;

            for(int i = 0; i < arr.length - 1; i++) {
                for(int j = 0; j < arr.length - 1; j++) {
                    if(arr[i] * 2 == arr[j]) count++;
                }
            }
            sb.append(count + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}