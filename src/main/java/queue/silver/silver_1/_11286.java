package queue.silver.silver_1;
import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
public class _11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)) return Math.abs(o1) - Math.abs(o2);
                else if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
                else return -1;
            }
        });

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(!queue.isEmpty()) sb.append(queue.poll() + "\n");
                else sb.append("0\n");
            }
            else queue.add(num);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}