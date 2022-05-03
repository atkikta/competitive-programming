import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        N = ni();
        Z = ni();
        W = ni();
        a = new int[N+1];
        for (int i = 0; i < N; i++) {
            a[i] = ni();
        }
        dp = new int[N-1][2];
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = 0;
        for (int i = 0; i < N-1; i++) {
            ans = Math.max(ans, dfs(i,0));
        }
        ans = Math.max(ans, Math.abs(a[N-1] - W));
        out.println(ans);
    }
    int dfs(int n, int p){
        if(dp[n][p]!=-1) return dp[n][p];
        if(n==N-2) return dp[n][p] = Math.abs(a[N-2] - a[N-1]); 
        int res=0;
        if(p==0){
            res = Integer.MAX_VALUE;
            for (int i = n+1; i <= N-2; i++) {
                res = Math.min(res, dfs(i,1));
            }
            res = Math.min(res, Math.abs(a[n]-a[N-1]));
        }else{
            res = 0;
            for (int i = n+1; i <= N-2; i++) {
                res = Math.max(res, dfs(i, 0));
            }
            res = Math.max(res, Math.abs(a[n]-a[N-1]));
        }
        return dp[n][p] = res;
    }
    int N;
    int Z;
    int W;
    int[] a;
    int[][] dp;
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