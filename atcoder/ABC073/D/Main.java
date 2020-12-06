import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int M = ni();
        R = ni();
        r = new int[R];
        used = new boolean[R];
        for (int i = 0; i < R; i++) {
            r[i] = ni()-1;
            used[i] = false;
        }
        MinCost mindis = new MinCost(N);
        int[][] cost = new int[N][N];
        for (int i = 0; i < M; i++) {
            int a = ni()-1;
            int b = ni()-1;
            int c = ni();
            mindis.add_edge(a,b,c);
            mindis.add_edge(b,a,c);
            cost[a][b] = c;
        }
        int[][] dt = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] d = mindis.dijkstra(i);
            // System.out.println(Arrays.toString(d));
            for (int j = 0; j < N; j++) {
                dt[i][j] = d[j];
            }
        }
        ArrayList<Integer> state = new ArrayList<>();
        dfs(state);
        long dis = Long.MAX_VALUE;
        for (ArrayList<Integer> p : perm) {
            long d = 0;
            for (int i = 1; i < p.size(); i++) {
                int from = p.get(i-1);
                int to = p.get(i);
                d += dt[from][to];
                // System.out.println(from + " " + to + " " + d);
            }
            dis = Math.min(dis, d);
        }
        // for (ArrayList<Integer> list : perm) {
        //     System.out.println(list.toString());
        // }
        long ans = dis;
        out.println(ans);
    }
    int R;
    int[] r;
    boolean[] used;
    ArrayList<ArrayList<Integer>> perm = new ArrayList<>();
    void dfs(ArrayList<Integer> state){
        if(state.size()>=R){
            perm.add(new ArrayList<>(state));
            return;
        }
        for (int i = 0; i < R; i++) {
            if(!used[i]){
                state.add(r[i]);
                used[i] = true;    
                dfs(state);
                used[i] = false;
                state.remove(state.size()-1);
            }
        }
    }
    class MinCost {
        ArrayList<ArrayList<Edge>> graph;
        boolean[] used;
        public MinCost(int node_size){
            this.used = new boolean[node_size];
            this.graph = new ArrayList<>();
            for (int i = 0; i < node_size; i++) {
                this.graph.add(new ArrayList<>());
            }
        }
        public void add_edge(int from, int to, int cost){
            Edge e = new Edge(from, to, cost);
            graph.get(from).add(e);
        }
        public int[] dijkstra(int s){
            PriorityQueue<ArrayList<Integer>> que = new PriorityQueue<>((x,y)->x.get(1).compareTo(y.get(1)));
            int[] dist = new int[graph.size()];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[s] = 0;
            que.add(new ArrayList<Integer>(Arrays.asList(s,0)));
            while(que.size()>0){
                var curr = que.poll();
                int curr_nod = curr.get(0);
                int curr_dis = curr.get(1);
                if(dist[curr_nod] < curr_dis) continue;
                for (Edge e : graph.get(curr.get(0))) {
                    if(dist[e.to] > curr_dis + e.cost){
                        dist[e.to] = curr_dis + e.cost;
                        que.add(new ArrayList<Integer>(Arrays.asList(e.to,curr_dis+e.cost)));
                    }             
                }
            }

            return dist;
        }
        public void print(){
            for (int i = 0; i < graph.size(); i++) {
                for (Edge e : graph.get(i)) {
                    System.out.println(String.format("from %d, to %d, cost %d", e.from, e.to, e.cost));
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