package implementation.bronze.bronze_4;
import java.io.*;
import java.util.HashSet;
import java.util.Set;
public class _28431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < 5; i++){
            int socks = Integer.parseInt(br.readLine());

            if(set.contains(socks)) set.remove(socks);
            else set.add(socks);
        }
        for(int result : set) bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}