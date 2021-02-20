import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = ni();
            int y = ni();
            nodes.add(new ArrayList<>(Arrays.asList(x, y, i)));

        }
        ArrayList<Edge> edges = new ArrayList<>();
        Collections.sort(nodes, (x,y)->x.get(0).compareTo(y.get(0)));
        for (int i = 1; i < N; i++) {
            int fromid =nodes.get(i-1).get(2);
            int toid =nodes.get(i).get(2);
            int dist = Math.min(Math.abs(nodes.get(i-1).get(0)-nodes.get(i).get(0)),Math.abs(nodes.get(i-1).get(1)-nodes.get(i).get(1)));
            edges.add(new Edge(fromid, toid, dist));
        }
        Collections.sort(nodes, (x,y)->x.get(1).compareTo(y.get(1)));
        for (int i = 1; i < N; i++) {
            int fromid =nodes.get(i-1).get(2);
            int toid =nodes.get(i).get(2);
            int dist = Math.min(Math.abs(nodes.get(i-1).get(0)-nodes.get(i).get(0)),Math.abs(nodes.get(i-1).get(1)-nodes.get(i).get(1)));
            edges.add(new Edge(fromid, toid, dist));
        }
        Collections.sort(edges, (e1, e2)->e1.cost.compareTo(e2.cost));
        UnionFind uf = new UnionFind(N);
        long ans = 0;
        for (Edge edge : edges) {
            if(uf.find(edge.from) != uf.find(edge.to)){
                uf.union(edge.from, edge.to);
                ans+= edge.cost;
            }
        }

        out.println(ans);
    }
    class UnionFind{
        int[] par;
        UnionFind(int n){
            par = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = -1;
            }
        }
        int find (int n){
            if(par[n] < 0){
                return n;
            }else{
                return find(par[n]);
            }
        }
        boolean union(int a, int b){
            a = find(a);
            b = find(b);
            if(a == b) return false;
            if(par[a] > par[b]){
                int temp = b;
                b = a;
                a = temp;
            }
            par[a] += par[b];
            par[b] = a;
            return true;
        }
        int par(int n){
            return par[n];
        }
        int size(int n){
            return -par[find(n)];
        }
        boolean same(int a, int b){
            return find(a) == find(b);
        }
    }
    class Edge{
        int from;
        int to;
        Integer cost;
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
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