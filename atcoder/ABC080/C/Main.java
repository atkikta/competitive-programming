import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int[][] F = new int[N][10];
        int[][] P = new int[N][11];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                F[i][j] = ni();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 11; j++) {
                P[i][j] = ni();
            }
        }
        long ans = -Long.MIN_VALUE;
        for (int i = 1; i < (1<<10); i++) {
            int[] coopen = new int[N];
            for (int j = 0; j <10 ; j++) {
                if(((i>>j)&1)==1){
                    for (int k = 0; k < N; k++) {
                        if(F[k][j]==1) coopen[k]++;
                    }
                }
            }
            long res = 0;
            for (int j = 0; j < N; j++) {
                res += P[j][coopen[j]];
            }
            ans = Math.max(ans, res);
        }
 
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