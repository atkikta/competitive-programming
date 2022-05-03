import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = 10;
        int[][] a = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = ns();
            for (int j = 0; j < N; j++) {
                if(s.charAt(j)=='o') a[i][j] = 1;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                boolean filled = false;
                if(a[i][j] == 0) {
                    a[i][j] = 1;
                    filled = true;
                }
                GridGraph gg = new GridGraph(a);
                boolean allconnected = true;
                for (int ii = 0; ii < N; ii++) {
                    for (int jj = 0; jj < N; jj++) {
                        if(a[ii][jj] == 1){
                            int[][] seen = gg.visitAllFrom(ii, jj);
                            for (int k = 0; k < N; k++) {
                                for (int l = 0; l < N; l++) {
                                    if(a[k][l] == 1 && seen[k][l] == 0) allconnected = false;
                                }
                            }
                        }
                        gg.resetSeen();
                    }
                }
                if(allconnected){
                    out.println("YES");
                    return;
                }
                if(filled) a[i][j] = 0;
            }
        }
        out.println("NO");
    }
    class GridGraph {
        int[][] grid;
        int[][] seen;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int H;
        int W;
        public GridGraph(int[][] a){
            this.grid = a;
            this.H = a.length;
            this.W = a[0].length;
            this.seen = new int[H][W];
        }
        public int[][] visitAllFrom(int h, int w){
            dfs(h, w);
            return this.seen;
        }
        public void resetSeen(){
            for (int i = 0; i < this.H; i++) {
                Arrays.fill(this.seen[i], 0);
            }
        }
        private void dfs(int h, int w){
            this.seen[h][w] = 1;
            for (int dir = 0; dir < 4; dir++) {
                int nh = h + dx[dir];
                int nw = w + dy[dir];
                if(nh < 0 || nw < 0 || nh >= H || nw >= W) continue;
                if(grid[nh][nw] == 0) continue;
                if(seen[nh][nw] == 1) continue;
                dfs(nh, nw);
            }
        }
    }
    final int mod = 1000000007;
    final BigInteger MOD = BigInteger.valueOf(mod);
    int upperBound(ArrayList<Long> list, Long target){
        int i = Collections.binarySearch(list, target, new UpperBoundComparator<Long>());
        return ~i;
    }
    class UpperBoundComparator<T extends Comparable<? super T>> implements Comparator<T>{
        public int compare(T x, T y){
            return (x.compareTo(y) > 0) ? 1 : -1;
        }
    }
    int lowerBound(ArrayList<Long> list, Long target){
        int i = Collections.binarySearch(list, target, new LowerBoundComparator<Long>());
        return ~i;
    }
    class LowerBoundComparator<T extends Comparable<? super T>> implements Comparator<T>{
        public int compare(T x, T y){
            return (x.compareTo(y) >= 0) ? 1 : -1;
        }
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