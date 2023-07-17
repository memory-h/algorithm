package dijkstra.gold.gold_5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Weight implements Comparable<Weight>{
    int end;
    int weight;

    public Weight(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Weight o) {
        return this.weight - o.weight;
    }
}
public class _14284 {
    static ArrayList<ArrayList<Weight>> list;
    static int[] dist;
    static boolean[] visited;
    static final int INF = 987654321;
    public static int dijkstra(int start, int end){
        PriorityQueue<Weight> q = new PriorityQueue<>();
        q.offer(new Weight(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()){
            Weight curNode = q.poll();
            int curr = curNode.end;

            if(!visited[curr]) {
                visited[curr] = true;

                for (Weight node : list.get(curr)) {
                    if (!visited[node.end] && dist[node.end] > dist[curr] + node.weight) {
                        dist[node.end] = dist[curr] + node.weight;
                        q.add(new Weight(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[end];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        Arrays.fill(dist, INF);

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Weight(end, weight));
            list.get(end).add(new Weight(start, weight));
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(a, b));
    }
}