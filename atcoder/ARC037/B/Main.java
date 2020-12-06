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
        DiGraph graph = new DiGraph(N);
        for (int i = 0; i < M; i++) {
            int u = ni()-1;
            int v = ni()-1;
            graph.addEdge(u, v);
            graph.addEdge(v, u);
        }
 
        long ans = graph.countTreeComponents();
        out.println(ans);
    }
    class DiGraph {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
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
        public void addEdge(int u, int v){
            this.graph.get(u).add(v);
        }
        public int countComponents(){
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
            for (Integer next : graph.get(state)) {
                if(next == prev) continue;
                if(visited[next] >= 0){
                    hasSycle[count] = 1;
                }else{
                    dfs(next, state, count);
                }
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