import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        String first = ns();
        String last = ns();
        int len = first.length();
        int N = ni();
        String[] s = new String[N];
        for (int i = 0; i < N; i++) {
            s[i] = ns();
        }
        if(first.equals(last)){
            out.println(0);
            out.println(first);
            out.println(last);
            return;
        }
        DiGraph graph = new DiGraph(N+2);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i==j) continue;
                int diff = 0;
                for (int k = 0; k < len; k++) {
                    if(s[i].charAt(k)!=s[j].charAt(k)) diff++;
                }
                if(diff==1){
                    graph.addEdge(i, j, 1);
                    graph.addEdge(j, i, 1);
                }
            }
            int diff = 0;
            for (int k = 0; k < len; k++) {
                if(first.charAt(k)!=s[i].charAt(k)) diff++;
            }
            if(diff==1){
                graph.addEdge(i, N, 1);
                graph.addEdge(N, i, 1);
            }
            diff = 0;
            for (int k = 0; k < len; k++) {
                if(last.charAt(k)!=s[i].charAt(k)) diff++;
            }
            if(diff==1){
                graph.addEdge(i, N+1, 1);
                graph.addEdge(N+1, i, 1);
            }
        }
        int diff = 0;
        for (int i = 0; i < len; i++) {
            if(first.charAt(i)!=last.charAt(i)) diff++;
        }
        if(diff==1){
            graph.addEdge(N, N+1, 1);
            graph.addEdge(N+1, N, 1);
        }
        long[] dis = graph.dijkstra(N);
        // System.out.println(Arrays.toString(graph.before));
 
        long ans = dis[N+1];
        if(ans==Long.MAX_VALUE){
            out.println(-1);
        }else{
            out.println(ans-1);
            ArrayList<String> path = new ArrayList<>();
            path.add(last);
            int at = graph.before[N+1];
            while(at!=N){
                path.add(s[at]);
                at = graph.before[at];
            }
            path.add(first);
            for (int i = path.size()-1; i >=0; i--) {
                out.println(path.get(i));
            }
        }
    }
class DiGraph {
    ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    int V;
    int[] visited;
    int[] hasSycle;
    int[] before;
    public DiGraph(int numNode){
        this.V = numNode;
        for (int i = 0; i < numNode; i++) {
            this.graph.add(new ArrayList<>());
        }
        visited = new int[V];
        Arrays.fill(visited, -1);
        hasSycle = new int[V+1];
        before = new int[numNode];
        Arrays.fill(before, -1);
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
                    before[e.to] = current.node_id;
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
    final int mod = 1000000007;
    final BigInteger MOD = BigInteger.valueOf(mod);

    int mul(int x, int y){
        int val = (int)((x * 1L * y) % mod);
        return val>=0 ? val : val+mod;
    }
    int add(int x, int y) {
        x += y;
        if(x < 0) x += mod;
        if(x>=mod) x -= mod;
        return x;
    }
    int sub(int x, int y){
        x = add(x,mod-y);
        if(x < 0) x += mod;
        if(x>=mod) x -= mod;
        return x;
    }
    String ns() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine(), " ");
        }
        return tok.nextToken();
    }
 
    int ni() throws IOException {
        return Integer.parseInt(ns());
    }
 
    long nl() throws IOException {
        return Long.parseLong(ns());
    }
 
    double nd() throws IOException {
        return Double.parseDouble(ns());
    }
 
    String[] nsa(int n) throws IOException {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = ns();
        }
        return res;
    }
 
    int[] nia(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ni();
        }
        return res;
    }
 
    long[] nla(int n) throws IOException {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = nl();
        }
        return res;
    }
 
    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
 
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        tok = new StringTokenizer("");
        Main main = new Main();
        main.solve();
        out.close();
    }
}