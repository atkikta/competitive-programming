import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        a = new int[N];
        for (int i = 0; i < N; i++){
            a[i] = ni();
        }
        csum = new long[N+1];
        for (int i = 1; i < csum.length; i++) {
            csum[i] = csum[i-1] + a[i-1];
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
        if(r-l==0){
            return dp[l][r] = 0;
        }else if(r-l==1){
            return dp[l][r] = 0;
        }
        if(dp[l][r] >= 0){
            return dp[l][r];
        }else{
            long res = Long.MAX_VALUE/2;
            for (int i = l+1; i < r; i++) {
                res = Math.min(res, dfs(l,i)+csum[i]-csum[l] + dfs(i,r)+csum[r]-csum[i]);
            }
            // System.out.println(String.format("%d %d %d", l, r, res));
            return dp[l][r] = res;
        }
    }
    int[] a;
    long dp[][];
    long[] csum;
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