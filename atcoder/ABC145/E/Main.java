import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int T = ni();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++){
            int a = ni();
            A[i] = a;
            int b = ni();
            B[i] = b;
        }

        int[][] dp1 = new int[N][T]; 
        int[][] dp2 = new int[N][T]; 
        for (int j = 0; j < T; j++) {
            if(j>=A[0]) dp1[0][j] = B[0];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < T; j++) {
                if(j>=A[i]) dp1[i][j] = Math.max(dp1[i][j], dp1[i-1][j-A[i]] + B[i]);
                dp1[i][j] = Math.max(dp1[i][j], dp1[i-1][j]);
            }
        }
        for (int j = 0; j < T; j++) {
            if(j>=A[N-1])dp2[N-1][j] = B[N-1];
        }
        for (int i = N-2; i >=0; i--) {
            for (int j = 0; j < T; j++) {
                if(j>=A[i]) dp2[i][j] = Math.max(dp2[i][j], dp2[i+1][j-A[i]] + B[i]);
                dp2[i][j] = Math.max(dp2[i][j], dp2[i+1][j]);
            }
        }
        // for (int i = 0; i < N; i++) {
        //     System.out.println(Arrays.toString(dp1[i]));
        // }
        // for (int i = 0; i < N; i++) {
        //     System.out.println(Arrays.toString(dp2[i]));
        // }
        long ans = 0;
        for (int i = 0; i < N-2; i++) {
            for (int j = 0; j < T; j++) {
                ans = Math.max(ans, dp1[i][j] + dp2[i+2][T-j-1] + B[i+1]);
            }
        }
        ans = Math.max(ans, dp1[N-2][T-1] + B[N-1]);
        ans = Math.max(ans, dp2[1][T-1] + B[0]);
        out.println(ans);
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