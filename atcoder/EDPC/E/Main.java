import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int W = ni();
        int[] v = new int[N];
        int[] w = new int[N];
        for (int i = 0; i < N; i++){
            w[i] = ni();
            v[i] = ni();
        }
        long dp[][] = new long[N+1][100010];
        for (int i = 0; i < N+1; i++) {
            Arrays.fill(dp[i],Long.MAX_VALUE/2);
        }
        dp[0][0]=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 100010; j++) {
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][Math.max(j-v[i], 0)] + w[i]);
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]);
            }
            // System.out.println(Arrays.toString(dp[i+1]));
        }
        // System.out.println(Arrays.toString(dp[N]));
        long ans = 0;
        for (int i = 0; i < 100010; i++) {
            if(dp[N][i]<=W){
                ans = i;
            }
        }
        out.println(ans);
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