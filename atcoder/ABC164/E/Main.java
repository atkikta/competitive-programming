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
        S = ni();
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        int maxa = 0;
        for (int i = 0; i < M; i++) {
            int u = ni()-1;
            int v = ni()-1;
            int a = ni();
            int b = ni();
            graph.get(u).add(new Edge(u, v, a, b));
            graph.get(v).add(new Edge(v, u, a, b));
            maxa = Math.max(maxa, a);
        }
        C = new int[N];
        D = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = ni();
            D[i] = ni();
        }
        maxm = maxa * (N-1);
        long[][] ans = dijkstra(0);
        // print2DArray(ans);
        for (int i = 1; i < N; i++) {
            long mintime = Long.MAX_VALUE;
            for (int j = 0; j <= maxm; j++) {
                mintime = Math.min(mintime, ans[i][j]);
            }
            out.println(mintime);
        }
    }
    ArrayList<ArrayList<Edge>> graph;
    int N;
    int S;
    int[] C;
    int[] D;
    int maxm;
    long[][] dijkstra(int i){
        long[][] res = new long[N][maxm+1];
        for (int j = 0; j < N; j++) {
            Arrays.fill(res[j], Long.MAX_VALUE);
        }
        res[i][Math.min(S, maxm)] = 0;
        PriorityQueue<Arrival> que = new PriorityQueue<>((x,y)->x.time.compareTo(y.time));
        que.add(new Arrival(i, 0, Math.min(S, maxm)));
        while(que.size()>0){
            Arrival current = que.poll();
            int nid = current.node_id;
            int ncmoney = Math.min(maxm, current.money + C[nid]);
            long nctime = current.time + D[nid];
            if(res[nid][ncmoney] > nctime){
                res[nid][ncmoney] = nctime;
                que.add(new Arrival(nid, nctime, ncmoney));
            }
            for (Edge e : graph.get(nid)) {
                long nexttime = current.time + e.time;
                int nextmoney = current.money - e.fee;
                if(nextmoney>=0 && res[e.to][nextmoney] > nexttime){
                    res[e.to][nextmoney] = nexttime;
                    que.add(new Arrival(e.to, nexttime, nextmoney));
                }
            }
        }
        return res;
    }
    class Edge{
        int from;
        int to;
        int fee;
        int time;
        public Edge(int from, int to, int fee, int time){
            this.from = from;
            this.to = to;
            this.fee = fee;
            this.time = time;
        }
    }
    class Arrival{
        Integer node_id;
        Long time;
        Integer money;
        public Arrival(int node_id, long time, int money){
            this.node_id = node_id;
            this.time = time;
            this.money = money;
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