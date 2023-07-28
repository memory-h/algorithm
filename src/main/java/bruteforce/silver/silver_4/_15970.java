package bruteforce.silver.silver_4;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class _15970 {
    static int n;
    private static int getSum(ArrayList<ArrayList<Integer>> list) {
        int sum = 0;
        for(int i = 0; i <= n; i++) Collections.sort(list.get(i));

        for(int i = 1; i <= n; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (j == 0) sum += list.get(i).get(j + 1) - list.get(i).get(j);
                else if (j == list.get(i).size() - 1) sum += list.get(i).get(j) - list.get(i).get(j - 1);
                else sum += Math.min(list.get(i).get(j + 1) - list.get(i).get(j),
                            list.get(i).get(j) - list.get(i).get(j - 1));
            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) list.add(new ArrayList<>());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            list.get(color).add(number);
        }
        int result = getSum(list);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}