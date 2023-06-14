package dijkstra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Street implements Comparable<Street>{
    int end;
    int weight;

    public Street(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Street o) {
        return this.weight - o.weight;
    }
}
public class _1240 {
    static ArrayList<ArrayList<Street>> list;
    static int[] dist;
    static boolean[] visited;
    static final int INF = 987654321;
    public static void dijkstra(int start, int end){
        PriorityQueue<Street> q = new PriorityQueue<>();
        q.offer(new Street(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()){
            Street curNode = q.poll();
            int curr = curNode.end;

            if(!visited[curr]) {
                visited[curr] = true;

                for (Street node : list.get(curr)) {
                    if (dist[node.end] > dist[curr] + node.weight) {
                        dist[node.end] = dist[curr] + node.weight;
                        q.add(new Street(node.end, dist[node.end]));
                    }
                }
            }
        }
        System.out.println(dist[end]);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Street(end, weight));
            list.get(end).add(new Street(start, weight));
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            visited = new boolean[N + 1];
            Arrays.fill(dist, INF);

            dijkstra(a, b);
        }
    }
}