import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        N = ni();
        int[] x = new int[N];
        int[] y = new int[N];
        int[] z = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = ni();
            y[i] = ni();
            z[i] = ni();
        }
        dist = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = Math.abs(x[i]-x[j]) + Math.abs(y[i]-y[j]) + Math.max(0,z[j]-z[i]);
            }
        }
        nset = (1<<N);
        dp = new long[nset][N];
        for (int i = 0; i < nset; i++) {
            Arrays.fill(dp[i],-1);
        }
        long ans = dfs(0, 0);
        // for (int i = 0; i < dp.length; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        out.println(ans);
    }
    long dfs(int set, int node){
        // System.out.println(String.format("%d %d", set, node));
        if(dp[set][node]>=0) return dp[set][node];
        if(set==(nset-1)) return dp[set][node] = dist[node][0];
        long d = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if(node!=i && ((set>>i)&1)==0){
                d = Math.min(d, dfs((set|(1<<i)),i)+dist[node][i]);
            }
        }
        // System.out.println(String.format("%d %d %d", set, node,d));
        return dp[set][node] = d;
    }
    int nset;
    int N;
    long dp[][];
    long dist[][];
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