import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        graph = new ArrayList<>();
        edges = new int[N-1];
        edgelist = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N-1; i++) {
            int a = ni()-1;
            int b = ni()-1;
            graph.get(a).add(new Edge(a, b, i));
            graph.get(b).add(new Edge(b, a, i));
            edgelist.add(new ArrayList<>(Arrays.asList(a, b)));
        }
        value = new long[N];
        dfs(0, -1);
        int Q = ni();
        for (int i = 0; i < Q; i++) {
            int t = ni();
            int e = ni()-1;
            long x = nl();
            if(t==1 && edges[e]==1){
                value[edgelist.get(e).get(1)] -= x;
                value[0] += x;
            }
            if(t==2 && edges[e]==1){
                value[edgelist.get(e).get(1)] += x;
            }
            if(t==1 && edges[e]==0){
                value[edgelist.get(e).get(0)] += x;
            }
            if(t==2 && edges[e]==0){
                value[edgelist.get(e).get(0)] -= x;
                value[0] += x;
            }
        }
        // System.out.println(Arrays.toString(value));
        dfs2(0,-1);
        // System.out.println(Arrays.toString(edges));
        for (int i = 0; i < N; i++) {
            out.println(value[i]);            
        }
    }
    ArrayList<ArrayList<Integer>> edgelist;
    int[] edges;
    void dfs2(int node, int before){
        for (Edge e: graph.get(node)) {
            if(e.to != before){
                value[e.to] += value[node];
                dfs2(e.to, node);
            }
        }
    }
    long[] value;
    ArrayList<ArrayList<Edge>> graph;
    void dfs(int node, int before){
        for (Edge e: graph.get(node)) {
            if(e.to != before){
                if(edgelist.get(e.id).get(0)==e.from)edges[e.id] = 1;
                dfs(e.to, node);
            }
        }
    }
    class Edge{
        int from;
        int to;
        int id;
        public Edge(int from, int to, int id){
            this.from = from;
            this.to = to;
            this.id = id;
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
    void print2DArray(int[][] a){
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