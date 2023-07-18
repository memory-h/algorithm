package bruteforce.silver.silver_5;
import java.io.*;
public class _8892 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        while(testCase --> 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            String find = null;

            for(int i = 0; i < n; i++) arr[i] = br.readLine();

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i != j) {
                        String str = arr[i] + arr[j];
                        StringBuffer sf = new StringBuffer(str);
                        String reverse = sf.reverse().toString();

                        if (str.equals(reverse)) find = str;
                    }
                }
            }
            if(find != null) bw.write(find + "\n");
            else bw.write("0\n");
        }
        bw.flush();
        bw.close();
    }
}