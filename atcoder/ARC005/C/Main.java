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
        int sh=0;
        int sw=0;
        int gh=0;
        int gw=0;
        for (int i = 0; i < H; i++) {
            String s = ns();
            for (int j = 0; j < W; j++) {
                if(s.charAt(j)=='#') grid[i][j] = 1;
                else if(s.charAt(j)=='s'){
                    sh = i;
                    sw = j;
                }
                else if(s.charAt(j)=='g'){
                    gh = i;
                    gw = j;
                }
            }
        }
        int[][][] dis = new int[3][H][W];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    dis[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        dis[0][sh][sw] = 0;
        int[] dh = {-1, 0, 1, 0};
        int[] dw = {0, 1, 0, -1};
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.addLast(sh);
        que.addLast(sw);
        que.addLast(0);
        while(que.size()>0){
            int nowh = que.poll();
            int noww = que.poll();
            int nowb = que.poll();
            for (int i = 0; i < 4; i++) {
                int nexth = nowh + dh[i];
                int nextw = noww + dw[i];
                if(nexth<0 || nexth>H-1 || nextw<0 || nextw>W-1) continue;
                if(grid[nexth][nextw]==1) continue;
                if(dis[nowb][nexth][nextw] > dis[nowb][nowh][noww]+1){
                    dis[nowb][nexth][nextw] = dis[nowb][nowh][noww]+1;
                    que.addLast(nexth);
                    que.addLast(nextw);
                    que.addLast(nowb);
                }
            }
            if(nowb<2){
                for (int i = 0; i < 4; i++) {
                    int nexth = nowh + dh[i];
                    int nextw = noww + dw[i];
                    if(nexth<0 || nexth>H-1 || nextw<0 || nextw>W-1) continue;
                    if(grid[nexth][nextw]==0) continue;
                    if(dis[nowb+1][nexth][nextw] > dis[nowb][nowh][noww]+1){
                        dis[nowb+1][nexth][nextw] = dis[nowb][nowh][noww]+1;
                        que.addLast(nexth);
                        que.addLast(nextw);
                        que.addLast(nowb+1);
                    }
                }
            }
        }
        long ans = dis[0][gh][gw];
        ans = Math.min(ans, dis[1][gh][gw]);
        ans = Math.min(ans, dis[2][gh][gw]);
        if(ans==Integer.MAX_VALUE){
            out.println("NO");
        }else{
            out.println("YES");
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