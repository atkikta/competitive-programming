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
        A = new int[N];
        B = new int[M];
        for (int i = 0; i < N; i++) {
            A[i] = ni();
        }
        for (int i = 0; i < M; i++) {
            B[i] = ni(); 
        }
        dp = new int[N+1][M+1];
        seen = new boolean[N+1][M+1];
        for (int i = 0; i < N+1 ; i++) {
            for (int j = 0; j < M+1; j++) {
                dp[i][j] = Integer.MAX_VALUE/2;
                seen[i][j] = false;
            }
            
        }
        int ans = dfs(N,M);
        // print2DArray(dp);
        out.println(ans);
    }
    int dfs(int i, int j){
        if(i==0) return j;
        if(j==0) return i;
        if(seen[i][j]) return dp[i][j];
        seen[i][j] = true;
        int ret = Integer.MAX_VALUE;
        ret = Math.min(ret, dfs(i-1, j)+1);
        ret = Math.min(ret, dfs(i, j-1)+1);
        ret = Math.min(ret, dfs(i-1, j-1)+ (A[i-1]==B[j-1]?0:1));

        return dp[i][j] = ret;
    }
    boolean[][] seen;
    int[][] dp;
    int N;
    int M;
    int[] A;
    int[] B;
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