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
        int sh = 0;
        int sw = 0;
        int gh = 0;
        int gw = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,ArrayList<ArrayList<Integer>>> warp = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(i, Integer.MAX_VALUE);
            warp.put(i, new ArrayList<>());
        }
        for (int i = 0; i < H; i++) {
            String a = ns();
            for (int j = 0; j < W; j++) {
                if(a.charAt(j)=='#') {
                    grid[i][j] = -2;
                }else if(a.charAt(j)=='.'){
                    grid[i][j] = -1;
                }else if(a.charAt(j)=='S'){
                    grid[i][j] = -1;
                    sh=i;
                    sw=j;
                }else if(a.charAt(j)=='G'){
                    grid[i][j] = -1;
                    gh=i;
                    gw=j;
                }else{
                    int c = a.charAt(j) - 'a';
                    grid[i][j] = c;
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    warp.get(c).add(list);
                }
            }
        }
        // print2DArray(grid);
        // System.out.println(warp);
        PriorityQueue<Node> que = new PriorityQueue<>((x,y)->x.cost.compareTo(y.cost));
        Node snode = new Node(sh, sw, 0);
        int[] dh = {-1, 0, 1, 0};
        int[] dw = {0, 1, 0, -1};
        int[][] dis = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        dis[sh][sw]=0;
        que.add(snode);
        while(que.size()>0){
            Node now = que.poll();
            // print2DArray(dis);
            if(grid[now.h][now.w]>=0){
                ArrayList<ArrayList<Integer>> list = warp.get(grid[now.h][now.w]);
                for(ArrayList<Integer> to: list){
                    if(to.get(0)!=now.h||to.get(1)!=now.w){
                        // System.out.println(to);
                        if(dis[to.get(0)][to.get(1)]>now.cost+1){
                            que.add(new Node(to.get(0), to.get(1), now.cost+1));
                            dis[to.get(0)][to.get(1)] = now.cost+1;
                        }
                    }
                }
                for (ArrayList<Integer> to: list) {
                    grid[to.get(0)][to.get(1)]=-1;
                }
            }
            for (int i = 0; i < 4; i++) {
                int nh = now.h + dh[i];
                int nw = now.w + dw[i];
                if(nh<0 || nh>H-1 || nw<0 || nw>W-1) continue;
                if(grid[nh][nw]==-2){
                    continue;
                }
                else{
                    if(dis[nh][nw]> now.cost+1){
                        dis[nh][nw] = now.cost+1;
                        que.add(new Node(nh, nw, now.cost+1));
                    }
                }
            }
        }
        int ans = dis[gh][gw];
        if(ans ==Integer.MAX_VALUE){
            out.println(-1);
        }else{
            out.println(ans);
        }
    }
    class Node{
        Integer h;
        Integer w;
        Integer cost;
        public Node(int h, int w, int cost){
            this.h = h;
            this.w = w;
            this.cost = cost;
        }
    }
    final int mod = 1000000007;
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