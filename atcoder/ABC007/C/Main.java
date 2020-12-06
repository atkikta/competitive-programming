import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int R = ni();
        int C = ni();
        int sy = ni()-1;
        int sx = ni()-1;
        int ty = ni()-1;
        int tx = ni()-1;
        int[][] c = new int[R][C];
        for (int i = 0; i < R; i++) {
            String s = ns();
            for (int j = 0; j < C; j++) {
                if(s.charAt(j)=='.') c[i][j] = 1;
            }
        }
        GridGraph gg = new GridGraph(c);
        int[][] ans = gg.distanceFrom(sy, sx);
        out.println(ans[ty][tx]);
    }
    public class GridGraph {
        int[][] grid;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int H;
        int W;
        public GridGraph(int[][] a){
            this.grid = a;
            this.H = a.length;
            this.W = a[0].length;
        }
        public int countComponents(){
            int[][] seen = new int[H][W];
            int count = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if(grid[i][j] == 1 && seen[i][j] == 0){
                        count++;
                        dfs(i, j, seen);
                    }
                }
            }
            return count;
        }
        public int[][] visitAllFrom(int h, int w){
            int[][] seen = new int[H][W];
            dfs(h, w, seen);
            return seen;
        }
        public int[][] distanceFrom(int sh, int sw){
            int[][] distance = new int[H][W];
            for (int i = 0; i < H; i++) {
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }
            ArrayDeque<Integer> que = new ArrayDeque<>();
            distance[sh][sw] = 0;
            que.addLast(sh);
            que.addLast(sw);
            while(que.size()>0){
                int h = que.pollFirst();
                int w = que.pollFirst();
                for (int dir = 0; dir < 4; dir++) {
                    int nh = h + dx[dir];
                    int nw = w + dy[dir];
                    if(nh < 0 || nw < 0 || nh >= H || nw >= W) continue;
                    if(grid[nh][nw] == 0) continue;
                    if(distance[nh][nw] <= distance[h][w] + 1) continue;
                    distance[nh][nw] = distance[h][w] + 1;
                    que.addLast(nh);
                    que.addLast(nw);
                }
            }
            return distance;
        }
        private void dfs(int h, int w, int[][] seen){
            seen[h][w] = 1;
            for (int dir = 0; dir < 4; dir++) {
                int nh = h + dx[dir];
                int nw = w + dy[dir];
                if(nh < 0 || nw < 0 || nh >= H || nw >= W) continue;
                if(grid[nh][nw] == 0) continue;
                if(seen[nh][nw] == 1) continue;
                dfs(nh, nw, seen);
            }
        }
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