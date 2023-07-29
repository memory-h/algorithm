package bruteforce.silver.silver_3;
import java.io.*;
import java.util.StringTokenizer;
public class _2503 {
    static int n;
    static String[] arr;
    static int[] strike;
    static int[] ball;

    private static boolean findRedundancyNumber(String str) {
        for(int i = 0; i < str.length() - 1; i++) {
            for(int j = i + 1; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)) return false;
            }
        }
        return true;
    }
    private static boolean findNumber(int num) {
        String str = String.valueOf(num);

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') return false;
        }
        boolean[] check = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            int tempStrike = 0;

            for(int j = 0; j < str.length(); j++) {
                if(arr[i].charAt(j) == str.charAt(j)) tempStrike++;
            }
            int tempBall = findBallCount(i, str);
            if(strike[i] == tempStrike && ball[i] == tempBall) check[i] = true;
        }
        for(int i = 1; i <= n; i++) {
            if(!check[i]) return false;
        }
        return true;
    }
    private static int findBallCount(int index, String str) {
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            for(int j = 0; j < str.length(); j++) {
                if(i != j && arr[index].charAt(i) == str.charAt(j)) count++;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new String[n + 1];
        strike = new int[n + 1];
        ball = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i] = st.nextToken();
            strike[i] = Integer.parseInt(st.nextToken());
            ball[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;

        for(int i = 123; i <= 987; i++) {
            if(findRedundancyNumber(String.valueOf(i))) {
                if (findNumber(i)) count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}