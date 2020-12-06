import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int[] a = new int[N];
        int[] b = new int[N];
        int[] c = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = ni();
            b[i] = ni();
            c[i] = ni();
        }
        int[][] dp = new int[N][3];
        dp[0][0] = a[0];
        dp[0][1] = b[0];
        dp[0][2] = c[0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i][0], dp[i-1][1]+a[i]);
            dp[i][0] = Math.max(dp[i][0], dp[i-1][2]+a[i]);
            dp[i][1] = Math.max(dp[i][1], dp[i-1][0]+b[i]);
            dp[i][1] = Math.max(dp[i][1], dp[i-1][2]+b[i]);
            dp[i][2] = Math.max(dp[i][2], dp[i-1][0]+c[i]);
            dp[i][2] = Math.max(dp[i][2], dp[i-1][1]+c[i]);
        }

        long ans = Math.max(dp[N-1][0], Math.max(dp[N-1][1], dp[N-1][2]));
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