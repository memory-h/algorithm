package hash_set.silver.silver_5;
import java.io.*;
import java.util.*;
public class _28445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<String> bodyColors = new HashSet<>();
        HashSet<String> tailColors = new HashSet<>();

        String dadBody = st.nextToken();
        String dadTail = st.nextToken();

        st = new StringTokenizer(br.readLine());
        String momBody = st.nextToken();
        String momTail = st.nextToken();

        bodyColors.add(dadBody);
        bodyColors.add(dadTail);
        bodyColors.add(momBody);
        bodyColors.add(momTail);

        tailColors.addAll(bodyColors);

        ArrayList<String> bodyList = new ArrayList<>(bodyColors);
        ArrayList<String> tailList = new ArrayList<>(tailColors);

        Collections.sort(bodyList);
        Collections.sort(tailList);

        for (String bodyColor : bodyList) {
            for (String tailColor : tailList) {
                sb.append(bodyColor + " " + tailColor +"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}