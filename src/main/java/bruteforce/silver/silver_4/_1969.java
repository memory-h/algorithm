package bruteforce.silver.silver_4;
import java.io.*;
import java.util.StringTokenizer;
public class _1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];
        String result = ""; int minCount = 0;

        for(int i = 0; i < n; i++) arr[i] = br.readLine();

        for(int i = 0; i < m; i++) {
            int[] dna = new int[91];
            int max = 0; char temp = ' ';

            for(int j = 0; j < n; j++) dna[arr[j].charAt(i)]++;

            for(char k = 'A'; k <= 'Z'; k++){
                if(dna[k] > max){
                    max = dna[k];
                    temp = k;
                }
            }
            result += temp;
            minCount += (n - max);
        }
        bw.write(result + "\n" + minCount);
        bw.flush();
        bw.close();
    }
}