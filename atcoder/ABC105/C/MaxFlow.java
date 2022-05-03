package library;
import java.util.*;

class MaxFlow {
    ArrayList<ArrayList<Edge>> graph;
    boolean[] used;
    public MaxFlow(int node_size){
        this.used = new boolean[node_size];
        this.graph = new ArrayList<>();
        for (int i = 0; i < node_size; i++) {
            this.graph.add(new ArrayList<>());
        }
    }
    public void add_edge(int from, int to, int cap){
        Edge F = new Edge(from, to,cap,graph.get(to).size());
        graph.get(from).add(F);
        Edge T = new Edge(to, from, 0, graph.get(from).size()-1);
        graph.get(to).add(T);
    }
    private Edge redge(Edge e){
        return this.graph.get(e.to).get(e.rev);
    }
    private int dfs(int v, int t, int f){
        if(v==t)return f;
        used[v] = true;
        for (Edge e:graph.get(v)){
            if(!used[e.to] && e.cap>0){
                int d = dfs(e.to, t, Math.min(f,e.cap));
                if(d>0){
                    e.cap -= d;
                    redge(e).cap += d;
                    return d;
                }
            }
        }
        return 0;
    }
    public int max_flow(int s, int t){
        int flow = 0;
        while(true){
            Arrays.fill(used, false);
            int f = dfs(s, t, Integer.MAX_VALUE);
            if(f==0) return flow;
            flow += f;
        }
    }
    public void print_flow(){
        for (int i = 0; i < graph.size(); i++) {
            for (Edge e : graph.get(i)) {
                System.out.println(String.format("from %d, to %d, cap %d", e.from, e.to, e.cap));
            }
        }
    }
    class Edge{
        int from;
        int to;
        int cap;
        int rev;
        public Edge(int from, int to, int cap, int rev){
            this.from = from;
            this.to = to;
            this.cap = cap;
            this.rev = rev;
        }
    }
}