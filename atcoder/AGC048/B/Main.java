import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        A = new long[N];
        B = new long[N];
        for (int i = 0; i < N; i++){
            A[i] = nl();
        } 
        for (int i = 0; i < N; i++){
            B[i] = nl();
        } 
        dp = new long[N+1][N+1];
        for (int i = 0; i < N+1; i++) {
            Arrays.fill(dp[i], -1);
        } 
        long ans = dfs(0,N);
        // for (int i = 0; i < N+1; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        out.println(ans);
    }
    long dfs(int l, int r){
        // System.out.println(String.format("%d %d", l, r));
        if(dp[l][r]>-1) return dp[l][r];
        if(r<=l) return dp[l][r] = 0;
        if(l==r-2) return dp[l][r] = Math.max(A[l]+A[l+1], B[l]+B[l+1]);
        long score = dfs(l+1, r-1)+ Math.max(A[l]+A[r-1], B[l]+B[r-1]);
        for (int i = l+2; i < r; i+=2) {
            score = Math.max(score, dfs(l,i) + dfs(i, r));
        }
        return dp[l][r] = score;

    }
    long[] A;
    long[] B;
    long[][] dp;
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