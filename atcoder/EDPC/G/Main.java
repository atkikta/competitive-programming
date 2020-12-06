import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        N = ni();
        M = ni();
        graph= new ArrayList<>();
        for (int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int x = ni()-1;
            int y = ni()-1;
            graph.get(x).add(y);
        }
        size = new int[N];
        seen = new int[N];
        Arrays.fill(seen, -1);
 
        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dfs(i));
        }
        out.println(ans);
    }
    int N;
    int M;
    int[] size;
    int[] seen;
    ArrayList<ArrayList<Integer>> graph;
    int dfs(int x){
        if(seen[x]==1) return size[x];
        seen[x] = 1;
        int res = 0;
        for (int i : graph.get(x)) {
            res = Math.max(res,dfs(i)+1);
        }
        size[x] = res;
        return res;
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