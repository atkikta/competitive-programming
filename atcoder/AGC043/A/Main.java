import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        H = ni();
        W = ni();
        grid = new int[H][W];
        for (int i = 0; i < H; i++) {
            var s = ns();
            for (int j = 0; j < W; j++) {
                if(s.charAt(j)=='.') grid[i][j]=0;
                if(s.charAt(j)=='#') grid[i][j]=1;
            }
        }
        int[][] dp = new int[H][W];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(i==0&&j==0) continue;
                if(i==0){
                    if(grid[i][j] == 1 && grid[i][j-1]==0) dp[i][j] = dp[i][j-1] +1;
                    else dp[i][j] = dp[i][j-1];
                }else if(j==0){
                    if(grid[i][j] == 1 && grid[i-1][j]==0) dp[i][j] = dp[i-1][j] +1;
                    else dp[i][j] = dp[i-1][j];
                }else{
                    int top = dp[i-1][j];
                    if(grid[i][j] == 1 && grid[i-1][j]==0)top++;
                    int left = dp[i][j-1];
                    if(grid[i][j] == 1 && grid[i][j-1]==0)left++;
                    dp[i][j] = Math.min(top,left);
                }
            }
        }
 
        out.println(dp[H-1][W-1]);
    }
    int H;
    int W;
    int[][] grid;
    int numb = Integer.MAX_VALUE;
    void dfs(int y, int x,int count){
        if(y==H-1 && x==W-1){
            if(count<numb) numb = count;
            return;
        }
        if(count>=numb) return;
        if(x<W-1){
            int nc = count;
            if (grid[y][x] == 0 && grid[y][x+1]==1 ) nc++;
            dfs(y,x+1,nc);
        }
        if(y<H-1){
            int nc = count;
            if(grid[y][x] == 0 && grid[y+1][x]==1) nc++;
            dfs(y+1,x,nc);
        }
    }
    final int mod = 1000000007;
    int mul(int x, int y){
        return (int)((x * 1L * y) % mod);
    }
    int add(int x, int y) {
        x += y;
        return x >= mod ? (x - mod) : x;
    }
    int sub(int x, int y){
        x = add(x,mod-y);
        return x >= mod ? (x - mod) : x;
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