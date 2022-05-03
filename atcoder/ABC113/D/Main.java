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
        int K = ni();
        if(W==1){
            out.println(1);
            return;
        }
        int[][] count = new int[W][2];
        count[0][0] = 1;
        count[0][1] = 1;
        count[1][0] = 1;
        count[1][1] = 1;
        for (int i = 1; i <= W-2; i++) {
            count[i+1][0] = add(count[i][0], count[i][1]);
            count[i+1][1] = count[i][0];
        } 
        int[][] dp = new int[H+1][W];
        dp[0][0] = 1;
        for (int i = 1; i <= H; i++) {
            for (int j = 0; j < W; j++) {
                if(j==0){
                    dp[i][j] = add(dp[i][j], mul(dp[i-1][j+1], count[W-1][1]));
                    dp[i][j] = add(dp[i][j], mul(dp[i-1][j], count[W-1][0]));
                }else if(j==W-1){
                    dp[i][j] = add(dp[i][j], mul(dp[i-1][j-1], count[W-1][1]));
                    dp[i][j] = add(dp[i][j], mul(dp[i-1][j], count[W-1][0]));
                }else{
                    dp[i][j] = add(dp[i][j], mul(dp[i-1][j-1], mul(count[j][1], count[W-j-1][0])));
                    dp[i][j] = add(dp[i][j], mul(dp[i-1][j+1], mul(count[j][0], count[W-j-1][1])));
                    dp[i][j] = add(dp[i][j], mul(dp[i-1][j], mul(count[j][0], count[W-j-1][0])));
                }
            }
        }

        // for (int i = 0; i < dp.length; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        long ans = dp[H][K-1];
        out.println(ans);
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