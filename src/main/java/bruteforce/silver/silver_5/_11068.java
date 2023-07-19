package bruteforce.silver.silver_5;
import java.io.*;
import java.util.ArrayList;
public class _11068 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase --> 0) {
            int n = Integer.parseInt(br.readLine());
            boolean check = false;

            for (int i = 2; i <= 64; i++) {
                if(!check) {
                    list = new ArrayList<>();
                    int num = n;

                    while (num != 0) {
                        list.add(num % i);
                        num /= i;
                    }
                    check = true;

                    for (int j = 0; j < list.size() / 2; j++) {
                        if (list.get(j) != list.get(list.size() - 1 - j)) {
                            check = false;
                            break;
                        }
                    }
                }
                else break;
            }
            if(check) sb.append("1\n");
            else sb.append("0\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}