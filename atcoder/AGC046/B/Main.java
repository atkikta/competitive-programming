import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        A = ni();
        B = ni();
        C = ni();
        D = ni();
        dp = new int[C+1][D+1];
        for (int i = 0; i < C+1; i++) {
            for (int j = 0; j < D+1; j++) {
                dp[i][j] = -1;
            }
        }
        dp[A][B] = 1;
        int ans = dfs(C, D);
        // for (int i = 0; i < dp.length; i++) {
        //     out.println(Arrays.toString(dp[i]));
        // }
        out.println(ans);
    }
    int A;
    int B;
    int C;
    int D;
    int[][] dp;
    int dfs(int h, int w){
        if(dp[h][w]!=-1){
            return dp[h][w];
        }else if(h==A && w==B){
            return 1;
        }
        int ret = 0;
        if(h-1>=A && w-1>=B){
            ret = add(ret, mul(dfs(h, w-1), h));
            ret = add(ret, mul(dfs(h-1, w), w));
            ret = sub(ret, mul(mul(dfs(h-1, w-1), h-1), w-1));
        } else if (h-1>=A && w==B){
            ret = add(ret, mul(dfs(h-1, w), w));
        } else if (w-1>=B && h==A){
            ret = add(ret, mul(dfs(h, w-1), h));
        }
        return dp[h][w] = ret;
    }
    final int mod = 998244353;
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