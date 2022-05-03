import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
    
    int[][] maze;
    int H;
    int W;
    void solve() throws IOException {
        H = ni();
        W = ni();
        maze = new int[H][W];
        for (int i = 0; i < H; i++) {
            String S = ns();
            for (int j = 0; j < W; j++) {
                maze[i][j] = S.charAt(j) == '#' ? -1: Integer.MAX_VALUE;
            }
        }
        int ans = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int[][] mc = new int[H][W];
                if(maze[i][j]>0){
                    for (int j2 = 0; j2 < maze.length; j2++) {
                        mc[j2] = maze[j2].clone();
                    }
                    mc[i][j] = 0;
                    ArrayDeque<Integer> que = new ArrayDeque<>();
                    que.add(i);
                    que.add(j);
                    while( que.size()>0){
                        int y = que.poll();
                        int x = que.poll();
                        if(x<W-1 && mc[y][x+1] > mc[y][x]+1){
                            mc[y][x+1] = mc[y][x] +1;
                            que.add(y);
                            que.add(x+1);
                        }
                        if(y<H-1 && mc[y+1][x] >mc[y][x]+1){
                            mc[y+1][x] = mc[y][x] + 1;
                            que.add(y+1);
                            que.add(x);
                        }
                        if(x>0 && mc[y][x-1] > mc[y][x] +1){
                            mc[y][x-1] = mc[y][x] + 1;
                            que.add(y);
                            que.add(x-1);
                        }
                        if(y>0 && mc[y-1][x] > mc[y][x]+1){
                            mc[y-1][x] = mc[y][x] +1;
                            que.add(y-1);
                            que.add(x);
                        }
                    }
                    int maxdis = 0;
                    for (int k = 0; k < H; k++) {
                        for (int k2 = 0; k2 < W; k2++) {
                            maxdis = Math.max(maxdis,mc[k][k2]);
                        }
                    }
                    ans = Math.max(ans,maxdis);
                }
            }
        }
        out.println(ans);
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