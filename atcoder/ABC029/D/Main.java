import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        String N = ns();
        int[] n = new int[N.length()];
        for (int i = 0; i < n.length; i++) {
            n[i] = Integer.valueOf(N.substring(i, i+1));
        }
        DigDP ddp = new DigDP(n);
        int ans = ddp.run();
        out.println(ans);
    }
    class DigDP {
        int[] N;
        DigDP(int[] N){
            this.N = N;
        }
        int run() {
            int[][][] dp = new int[N.length+1][2][N.length+1];
            dp[0][0][0] = 1;
            for (int i = 0; i < N.length; i++) {
                int dig = N[i];
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < N.length; k++) {
                        for (int x = 0; x < ((j==1)?9:dig)+1; x++) {
                            dp[i+1][(j==1||x<dig)?1:0][(x==1)?k+1:k] += dp[i][j][k];
                        }
                    }
                }
            }
    
            int ans = 0;
            for (int i = 0; i < N.length+1; i++) {
                ans += dp[N.length][0][i]*i + dp[N.length][1][i]*i; 
            }
            return ans;
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