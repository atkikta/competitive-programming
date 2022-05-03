import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        H = ni();
        W = ni();
        int K = ni();
        grid = new int[H][W];
        dp = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                grid[i][j] = -1;
            }
        }
        for (int i = 0; i < K; i++) {
            int h = ni()-1;
            int w = ni()-1;
            String c = ns();
            if(c.equals("R")) grid[h][w] = 0;
            if(c.equals("D")) grid[h][w] = 1;
            if(c.equals("X")) grid[h][w] = 2;
        }
        dp[0][0] = 1;
        int[] colfree = new int[W];
        Arrays.fill(colfree, 1);
        for (int i = 0; i < H ; i++) {
            int rowfree = 1;
            for (int j = 0; j < W; j++) {
                if(i>0){
                    if(grid[i-1][j]==-1)dp[i][j] = add(dp[i][j], mul(rowfree, mul(dp[i-1][j],2)));
                    if(grid[i-1][j]==1 || grid[i-1][j]==2)dp[i][j] = add(dp[i][j], mul(rowfree, dp[i-1][j]));
                }
                if(j>0){
                    if(grid[i][j-1] == -1)dp[i][j] = add(dp[i][j], mul(colfree[j],mul(dp[i][j-1],2)));
                    if(grid[i][j-1]==0 || grid[i][j-1]==2) dp[i][j] = add(dp[i][j], mul(colfree[j], dp[i][j-1]));
                }
                if(grid[i][j]==-1) {
                    rowfree = mul(rowfree,3);
                    colfree[j] = mul(colfree[j], 3);
                }
            }
        }
        if(grid[H-1][W-1]==-1) dp[H-1][W-1] = mul(dp[H-1][W-1], 3);
        out.println(dp[H-1][W-1]);        
    }
    int H;
    int W;
    int[][] grid;
    int[][] dp;
    int dfs(int h, int w){
        if(dp[h][w]!=-1)return dp[h][w];
        int ret = 0;
        if(grid[h][w]==0){
            if(w+1<W) ret = dfs(h,w+1);
        }
        else if(grid[h][w]==1){
            if(h+1<H) ret = dfs(h+1,w);
        }
        else if(grid[h][w]==2){
            if(w+1<W) ret = add(ret, dfs(h,w+1));
            if(h+1<H) ret = add(ret, dfs(h+1,w));
        }else{
            int r = w+1<W ? dfs(h,w+1) : 0;
            int d = h+1<H ? dfs(h+1,w) : 0;
            ret = add(ret, mul(add(r,d),3));
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