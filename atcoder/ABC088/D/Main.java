import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int H = ni();
        int W = ni();
        int[][] grid = new int[H][W];
        int numw = 0;
        for (int i = 0; i < H; i++) {
            String s = ns();
            for (int j = 0; j < W; j++) {
                if(s.charAt(j) == '.') {
                    grid[i][j] = Integer.MAX_VALUE;
                    numw++;
                }
                else grid[i][j] = -1;
            }
        }
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(0);
        que.add(0);
        grid[0][0] = 0;
        while(que.size()>0){
            int i = que.poll();
            int j = que.poll();
            if(i+1<H && grid[i+1][j]>grid[i][j]+1){
                grid[i+1][j] = grid[i][j] +1;
                que.addLast(i+1);
                que.addLast(j);
            }
            if(j+1<W && grid[i][j+1]>grid[i][j]+1){
                grid[i][j+1] = grid[i][j] +1;
                que.addLast(i);
                que.addLast(j+1);
            }
            if(i-1>=0 && grid[i-1][j]>grid[i][j]+1){
                grid[i-1][j] = grid[i][j] +1;
                que.addLast(i-1);
                que.addLast(j);
            }
            if(j-1>=0 && grid[i][j-1]>grid[i][j]+1){
                grid[i][j-1] = grid[i][j] +1;
                que.addLast(i);
                que.addLast(j-1);
            }
        }
        if(grid[H-1][W-1] == Integer.MAX_VALUE){
            out.println(-1);
        }else{
            out.println(numw - grid[H-1][W-1]-1);
        }
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