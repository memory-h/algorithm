package dijkstra.gold.gold_5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Farmstead implements Comparable<Farmstead>{
    int end;
    int weight;

    public Farmstead(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Farmstead o) {
        return this.weight - o.weight;
    }
}
public class _5972 {
    static ArrayList<ArrayList<Farmstead>> list;
    static int[] dist;
    static boolean[] visited;
    static final int INF = 987654321;
    public static int dijkstra(int start, int end){
        PriorityQueue<Farmstead> q = new PriorityQueue<>();
        q.offer(new Farmstead(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()){
            Farmstead curNode = q.poll();
            int curr = curNode.end;

            if(!visited[curr]) {
                visited[curr] = true;

                for (Farmstead node : list.get(curr)) {
                    if (!visited[node.end] && dist[node.end] > dist[curr] + node.weight) {
                        dist[node.end] = dist[curr] + node.weight;
                        q.add(new Farmstead(node.end, dist[node.end]));
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

            list.get(start).add(new Farmstead(end, weight));
            list.get(end).add(new Farmstead(start, weight));
        }
        System.out.println(dijkstra(1, N));
    }
}