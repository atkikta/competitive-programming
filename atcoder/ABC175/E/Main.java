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
        int K = ni();
        int[][] item = new int[R][C];
        for (int i = 0; i < K; i++) {
            int r = ni()-1;
            int c = ni()-1;
            int v = ni();
            item[r][c] = v;
        }
        long[][][] dp = new long[R][C][4];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < 4; k++) {
                    dp[i][j][k] = Long.MIN_VALUE;
                }
            }
        }
        dp[0][0][0] = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int k = 2; k >=0 ; k--){
                    if(dp[i][j][k] >= 0) {
                        dp[i][j][k+1] = Math.max(dp[i][j][k+1], dp[i][j][k] + item[i][j]);
                    }
                }
                for (int k = 0; k < 4; k++) {
                    if(dp[i][j][k] >= 0){
                        if(i+1<R){
                            dp[i+1][j][0] = Math.max(dp[i+1][j][0], dp[i][j][k]);
                        }
                        if(j+1<C){
                            dp[i][j+1][k] = Math.max(dp[i][j+1][k], dp[i][j][k]);
                        }
                    }
                }                    
            }
        }

        long ans = dp[R-1][C-1][3];
        ans = Math.max(ans, dp[R-1][C-1][2]);
        ans = Math.max(ans, dp[R-1][C-1][1]);
        ans = Math.max(ans, dp[R-1][C-1][0]);
        out.println(ans);
    }
    int top3(int[] v, int s, int t){
        int firs=0;
        int seco=0;
        int thir=0;
        for (int i = s; i <= t; i++) {
            if(firs < v[i]){
                thir = seco;
                seco = firs;
                firs = v[i];
            }else if(seco < v[i]){
                thir = seco;
                seco = v[i];
            }else if(thir < v[i]){
                thir = v[i];
            }
        }
        return firs + seco + thir;
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