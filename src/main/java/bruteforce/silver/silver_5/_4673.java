package bruteforce.silver.silver_5;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
public class _4673 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        boolean[] check = new boolean[10001];

        for(int i = 1; i <= 10000; i++) {
            int temp = i; int cache = temp;

            while(temp != 0) {
                cache += temp % 10;
                temp /= 10;
            }
            if(cache <= 10000) check[cache] = true;
        }
        for(int i = 1; i <= 10000; i++) {
            if(!check[i]) sb.append(i + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}