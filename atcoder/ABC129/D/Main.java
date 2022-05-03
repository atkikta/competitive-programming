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
        int[][] left = new int[H][W];
        int[][] right = new int[H][W];
        int[][] up = new int[H][W];
        int[][] down = new int[H][W];

        for (int i = 0; i < H; i++) {
            int at = 0;
            for (int j = 0; j < W; j++) {
                left[i][j] = at;
                if(grid[i][j]==1) at = j+1;
            }
        }
        for (int i = 0; i < H; i++) {
            int at = W;
            for (int j = W-1; j >=0; j--) {
                right[i][j] = at;
                if(grid[i][j]==1) at = j;
            }
        }
        for (int j = 0; j < W; j++) {
            int at = 0;
            for (int i = 0; i < H; i++) {
                up[i][j] = at;
                if(grid[i][j]==1) at = i+1;
            }
        }
        for (int j = 0; j < W; j++) {
            int at = H;
            for (int i = H-1; i>=0; i--) {
                down[i][j] = at;
                if(grid[i][j]==1) at = i;
            }
        }
        long ans = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(grid[i][j]==1) continue;
                int count = right[i][j] - left[i][j] + down[i][j] - up[i][j];
                // System.out.println(String.format("%d %d %d %d",  right[i][j],left[i][j],down[i][j],up[i][j]));
                count--;
                ans = Math.max(ans, count);
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