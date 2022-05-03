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
            String s = ns();
            for (int j = 0; j < W; j++) {
                if(s.charAt(j)=='#') grid[i][j] = 1;
            }
        }
        conn = new int[H][W];
        count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(conn[i])
            }
        }
        long ans = 0;
 
        out.println(ans);
    }
    void dfs(int i, int j, int[][] visited){
        // System.out.print(i);
        // System.out.println(j);
        // for (int k = 0; k < H; k++) {
        //     for (int k2 = 0; k2 < W; k2++) {
        //         System.out.print(visited[k][k2]);
        //     }
        //     System.out.println();
        // }
        int ccur = grid[i][j];
        if(ccur == 0) count++;
        visited[i][j] = 1;
        if(i<H-1 && visited[i+1][j]!=1 && ccur + grid[i+1][j]==1) dfs(i+1,j,visited);
        if(i>0   && visited[i-1][j]!=1 && ccur + grid[i-1][j]==1) dfs(i-1,j,visited);
        if(j<W-1 && visited[i][j+1]!=1 && ccur + grid[i][j+1]==1) dfs(i,j+1,visited);
        if(j>0   && visited[i][j-1]!=1 && ccur + grid[i][j-1]==1) dfs(i,j-1,visited);
    }
    int H;
    int W;
    int count;
    int[][] grid;
    int[][] conn;
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