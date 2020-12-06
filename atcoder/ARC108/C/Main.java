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
        graph = new ArrayList<>();
        value = new int[N];
        Arrays.fill(value, -1);
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int u = ni()-1;
            int v = ni()-1;
            int c = ni();
            graph.get(u).add(new Edge(u, v, c));
            graph.get(v).add(new Edge(v, u, c));
        }
        HashSet<Integer> set = new HashSet<>();
        for (Edge edge : graph.get(0)) {
            set.add(edge.label);
        }
        int first=-1;
        for (int i = 1; i <=N; i++) {
            if(!set.contains(i)){
                first = i;
                break;
            }
        }
        dfs(0, first, true);
        for (int i = 0; i < N; i++) {
            out.println(value[i]);
        }
    }
    int N;
    ArrayList<ArrayList<Edge>> graph;
    int[] value;
    void dfs(int node, int val, boolean same){
        if(same){
            value[node] = val;
        }else{
            value[node] = (val + 1)%N + 1;
        }
        for (Edge edge : graph.get(node)) {
            if(value[edge.to]==-1){
                if(edge.label != value[node])dfs(edge.to, edge.label, true);
                else dfs(edge.to, edge.label, false);
            }
        }
    }
    class Edge{
        int from;
        int to;
        int label;
        public Edge(int from, int to, int label){
            this.from = from;
            this.to = to;
            this.label = label;
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