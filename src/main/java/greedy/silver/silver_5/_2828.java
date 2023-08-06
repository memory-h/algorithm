package greedy.silver.silver_5;
import java.io.*;
import java.util.StringTokenizer;
public class _2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());

        int result = 0;
        int frontBasket = 1, endBasket = m;

        for(int i = 0; i < j; i++){
            int apple = Integer.parseInt(br.readLine());

            if(apple < frontBasket){
                result += frontBasket - apple;
                endBasket -= frontBasket - apple;
                frontBasket = apple;
            }
            else if(apple > endBasket){
                result += apple - endBasket;
                frontBasket += apple - endBasket;
                endBasket = apple;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}