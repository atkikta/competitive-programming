import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int H = ni();
        int W  = ni();
        int[][] grid = new int[H][W];
        for (int i = 0; i < H; i++) {
            String s = ns();
            for (int j = 0; j < W; j++) {
                if(s.charAt(j)=='#') grid[i][j] = 1;
            }
        }
        int[][] orig = new int[H+2][W+2];
        for (int i = 0; i < H+2; i++) {
            for (int j = 0; j < W+2; j++) {
                orig[i][j] = 1;
            }
        }
        for (int i = 1; i < H+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if(grid[i-1][j-1]==0){
                    orig[i-1][j-1] = 0;
                    orig[i-1][j] = 0;
                    orig[i-1][j+1] = 0;
                    orig[i][j-1] = 0;
                    orig[i][j] = 0;
                    orig[i][j+1] = 0;
                    orig[i+1][j-1] = 0;
                    orig[i+1][j] = 0;
                    orig[i+1][j+1] = 0;
                }
            }
        }
        int[][] aftr = new int[H+2][W+2];
        for (int i = 1; i < H+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if(orig[i][j]==1){
                    aftr[i-1][j-1] = 1;
                    aftr[i-1][j] = 1;
                    aftr[i-1][j+1] = 1;
                    aftr[i][j-1] = 1;
                    aftr[i][j] = 1;
                    aftr[i][j+1] = 1;
                    aftr[i+1][j-1] = 1;
                    aftr[i+1][j] = 1;
                    aftr[i+1][j+1] = 1;
                }
            }
        }
        
        boolean ans = true;
        for (int i = 1; i < H+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if(grid[i-1][j-1]!=aftr[i][j]) ans = false;
            }
        }
        if(ans){
            out.println("possible");
            for (int i = 1; i < H+1; i++) {
                for (int j = 1; j < W+1; j++) {
                    if(orig[i][j]==1)out.print("#");
                    else out.print(".");
                }
                out.println();
            }
        }else{
            out.println("impossible");
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