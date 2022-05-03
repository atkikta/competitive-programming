import java.util.ArrayList;
import java.util.Arrays;

public class DiGraph {
    ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    int V;
    int[] visited;
    int[] hasSycle;
    public DiGraph(int numNode){
        this.V = numNode;
        for (int i = 0; i < numNode; i++) {
            this.graph.add(new ArrayList<>());
        }
        visited = new int[V];
        Arrays.fill(visited, -1);
        hasSycle = new int[V+1];
    }
    public void addEdge(int u, int v, int c){
        this.graph.get(u).add(new Edge(u,v,c));
    }
    public long[] dijkstra(int i){
        long[] res = new long[V];
        Arrays.fill(res, Long.MAX_VALUE);
        PriorityQueue<Pair> que = new PriorityQueue<>((x,y)->x.cost.compareTo(y.cost));
        res[i] = 0;
        que.add(new Pair(i, 0));
        while(que.size()>0){
            Pair current = que.poll();
            for (Edge e : graph.get(current.node_id)) {
                long newcost = current.cost + e.cost;
                if(res[e.to] > newcost){
                    res[e.to] = newcost;
                    que.add(new Pair(e.to, newcost));
                }
            }
        }
        return res;
    }
    public int countComponents(){
        Arrays.fill(visited, -1);
        Arrays.fill(hasSycle, 0);
        int count = 0;
        for (int i = 0; i < V; i++) {
            if(visited[i]==-1){
                dfs(i, -1, count);
                count++;
            }
        }
        // System.out.println(Arrays.toString(visited));
        // System.out.println(Arrays.toString(hasSycle));
        return count;
    }
    public int countTreeComponents(){
        int numComponent = countComponents();
        int countTree = 0;
        for (int i = 0; i < numComponent; i++) {
            if(hasSycle[i]==0) countTree++;
        }
        return countTree;
    }

    void dfs(int state, int prev, int count){
        visited[state] = count;
        for (Edge e : graph.get(state)) {
            if(e.to == prev) continue;
            if(visited[e.to] >= 0){
                hasSycle[count] = 1;
            }else{
                dfs(e.to, state, count);
            }
        }
    }
    class Edge{
        int from;
        int to;
        int cost;
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    class Pair{
        Integer node_id;
        Long cost;
        public Pair(int node_id, long cost){
            this.node_id = node_id;
            this.cost = cost;
        }
    }
}