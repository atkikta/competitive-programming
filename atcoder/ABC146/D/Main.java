import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N-1; i++) {
            int a = ni()-1;
            int b = ni()-1;
            graph.get(a).add(new Edge(i, a, b));
            graph.get(b).add(new Edge(i, b, a));
        }
        // System.out.println(String.format("%d %d %d", graph.get(0).get(0).id,graph.get(0).get(0).from,graph.get(0).get(0).to));
        // System.out.println(String.format("%d %d %d", graph.get(1).get(0).id,graph.get(1).get(0).from,graph.get(1).get(0).to));

        
        int maxCol = 0;
        int root = 0;
        for (int i = 0; i < N; i++) {
            if(graph.get(i).size()>maxCol){
                maxCol = graph.get(i).size();
                root = i;
            }
        }
        int[] ans = new int[N-1];
        Arrays.fill(ans,-1);
        ArrayDeque<Data> que = new ArrayDeque<>();
        que.add(new Data(root, -1));
        while(que.size()>0){
            Data data = que.poll();
            int node = data.node;
            int usedcol = data.col;
            // System.out.println(String.format("%d %d", node, usedcol));
            int[] used = new int[maxCol];
            if(usedcol>=0) used[usedcol] = 1;
            int col = 0;
            for (Edge edge : graph.get(node)) {
                // System.out.println(String.format("%d %d %d", edge.id, edge.from, edge.to));
                if(ans[edge.id]==-1){
                    while(used[col]==1) col++;
                    ans[edge.id] = col;
                    used[col] = 1;
                    que.add(new Data(edge.to, col));
                }
                
            }
        }
        out.println(maxCol);
        for (int i = 0; i < N-1; i++) {
            out.println(ans[i]+1);
        }
    }
    class Data{
        int node;
        int col;
        Data(int node, int col){
            this.node=node;
            this.col=col;
        }
    }
    class Edge{
        int id;
        int from;
        int to;
        Edge(int id, int from, int to){
            this.id = id;
            this.from = from;
            this.to = to;
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