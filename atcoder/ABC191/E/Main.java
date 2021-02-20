import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        N = ni();
        int M = ni();
        int[] A = new int[M];
        int[] B = new int[M];
        int[] C = new int[M];
        long[] selfloop = new long[N];
        Arrays.fill(selfloop, Long.MAX_VALUE/2);
        for (int i = 0; i < M; i++) {
            A[i] = ni()-1;
            B[i] = ni()-1;
            C[i] = ni();
            if(A[i] == B[i]) selfloop[A[i]] = Math.min(selfloop[A[i]], C[i]);
        }
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            graph.get(A[i]).add(new Edge(A[i], B[i], C[i]));
        }
        long[][] distf = new long[N][N];
        for (int i = 0; i < N; i++) {
            long[] di = dijkstra(i);
            for (int j = 0; j < N; j++) {
                distf[i][j] = di[j];
            }
        }
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            graph.get(B[i]).add(new Edge(B[i], A[i], C[i]));
        }
        long[][] distb = new long[N][N];
        for (int i = 0; i < N; i++) {
            long[] di = dijkstra(i);
            for (int j = 0; j < N; j++) {
                distb[i][j] = di[j];
            }
        }
        // print2DArray(distf);
        // print2DArray(distb);
        for (int i = 0; i < N; i++) {
            long mind = Long.MAX_VALUE/2;
            if(selfloop[i] != Long.MAX_VALUE/2) mind = selfloop[i];
            for (int j = 0; j < N; j++) {
                if(i==j)continue;
                if(distf[i][j]!=Long.MAX_VALUE && distb[i][j]!=Long.MAX_VALUE){
                    mind = Math.min(mind, distf[i][j] + distb[i][j]);
                }
            }
            if(mind == Long.MAX_VALUE/2) out.println(-1);
            else out.println(mind);
        }
    }
    int N ;
    ArrayList<ArrayList<Edge>> graph;
    public long[] dijkstra(int i){
        long[] res = new long[N];
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
    final int mod = 1000000007;
    final BigInteger MOD = BigInteger.valueOf(mod);
    
    long gcd(long num1,long num2) {
        if(num2 == 0) return num1;
        else return gcd(num2 , num1 % num2 );
    }
    long lcm(long a, long b){
        return (a / gcd(a, b)) * b;
    }
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
    void print2DArray(long[][] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
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