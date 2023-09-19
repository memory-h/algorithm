package greedy.silver.silver_2;
import java.io.*;
public class _2885 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 20; i++) {

            // k가 2의 거듭제곱 일 때
            if (k == Math.pow(2, i)) {
                bw.write((int) Math.pow(2, i) + " " + 0);
                break;
            }

            // 아니면 k보다 큰 2의 거듭제곱을 찾는다.
            else if (k < Math.pow(2, i)) {
                int temp = (int) Math.pow(2, i) / 2;
                int sum = temp;
                int count = 1;

                // 막대를 두 조각으로 쪼개면서 (sum + temp)가 k보다 작으면 계속 더해주고, 같아질 때 멈춘다.
                while (temp > 0) {
                    if (sum + temp == k) break;
                    else if (sum + temp < k) sum += temp;

                    temp /= 2;
                    count++;
                }
                bw.write((int) Math.pow(2, i) + " " + count);
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}