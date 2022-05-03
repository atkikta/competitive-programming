import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        N = ni();
        dp = new double[N+1][N+1][N+1];
        int count1=0;
        int count2=0;
        int count3=0;
        for (int i = 0; i < N; i++) {
            int a = ni();
            if(a==1) count1++;
            if(a==2) count2++;
            if(a==3) count3++;
        }
        seen = new int[N+1][N+1][N+1];
        for (int i = 0; i <=count1; i++) {
            for (int j = 0; j <=count2; j++) {
                for (int k = 0; k <= count3; k++) {
                    seen[i][j][k] = -1;
                }
            }
        }
        double ans = dfs(count1, count2, count3);
        // for (int i = 0; i < N+1; i++) {
        //     for (int j = 0; j < N+1; j++) {
        //         for (int k = 0; k < N+1; k++) {
        //             System.out.println(dp[i][j][k]);
        //         }
        //     }
        // }
        out.println(ans);
    }
    double dfs(int c1, int c2, int c3){
        if(c1<0||c2<0||c3<0){
            return 0.0;
        }else if(seen[c1][c2][c3] == 1){
            return dp[c1][c2][c3];
        }else if(c1==0 && c2==0 && c3==0){
            return 0.0;
        }
        seen[c1][c2][c3] = 1;
        double p1 = c1*1.0/N;
        double p2 = c2*1.0/N;
        double p3 = c3*1.0/N;
        double p0 = 1-p1-p2-p3;
        return dp[c1][c2][c3] = 1.0/(1.0-p0)*(1 + dfs(c1-1,c2,c3)*p1 + dfs(c1+1,c2-1,c3)*p2 + dfs(c1,c2+1,c3-1)*p3);
    }
    int[][][] seen;
    double[][][] dp;
    int N;
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