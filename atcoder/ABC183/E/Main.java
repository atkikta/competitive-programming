import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int H = ni();
        int W = ni();
        int[][] grid = new int[H][W];
        for (int i = 0; i < H; i++) {
            String s = ns();
            for (int j = 0; j < W; j++) {
                if(s.charAt(j)=='#') grid[i][j] = 1;
            }
        }
        int[][] dp = new int[H][W];
        dp[0][0] = 1;
        int[][] cr = new int[H][W];
        cr[0][0] = 1;
        int[][] cd = new int[H][W];
        cd[0][0] = 1;
        int[][] crd = new int[H][W];
        crd[0][0] = 1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(grid[i][j] == 1) continue;
                if(j>=1) dp[i][j] = add(dp[i][j] ,cr[i][j-1]);  
                if(i>=1) dp[i][j] = add(dp[i][j] ,cd[i-1][j]);
                if(i>=1&&j>=1) dp[i][j] = add(dp[i][j] , crd[i-1][j-1]);
                
                if(j>=1) cr[i][j] = add(cr[i][j-1], dp[i][j]);
                else cr[i][j] = dp[i][j];
                if(i>=1) cd[i][j] = add(cd[i-1][j], dp[i][j]);
                else cd[i][j] = dp[i][j];
                if(i>=1&&j>=1) crd[i][j] = add(crd[i-1][j-1], dp[i][j]);
                else crd[i][j] = dp[i][j];
                
            }
        }
        // for (int i = 0; i < H; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        long ans = dp[H-1][W-1];
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