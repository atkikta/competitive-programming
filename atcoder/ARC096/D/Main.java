import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        long C = nl();
        long[] x = new long[N];
        long[] v = new long[N];
        for (int i = 0; i < N; i++){
            x[i] = nl();
            v[i] = nl();
        }
        long[] csum = new long[N];
        long[] csumr = new long[N];
        csum[0] = v[0];
        csumr[0] = v[N-1];
        for (int i = 1; i <N; i++) {
            csum[i] = csum[i-1] + v[i];
            csumr[i] = csumr[i-1] + v[N-i-1];
        }
        long[] val = new long[N];
        long[] var = new long[N];
        val[0] = v[0] - x[0];
        var[0] = v[N-1] - (C - x[N-1]);
        for (int i = 1; i < N; i++) {
            val[i] = val[i-1] + v[i] - (x[i]-x[i-1]);
            var[i] = var[i-1] + v[N-1-i] - (x[N-i]-x[N-1-i]);
        }
        long[] maxl = new long[N];
        long[] maxr = new long[N];
        maxl[0] = val[0];
        maxr[0] = var[0];
        for (int i = 1; i < N; i++) {
            maxl[i] = Math.max(maxl[i-1], val[i]);
            maxr[i] = Math.max(maxr[i-1], var[i]);
        }
        long ans = maxl[N-1];
        for (int i = 0; i < N-1; i++) {
            long res = csumr[i] - (C-x[N-i-1])*2;
            res = res + maxl[N-i-2];
            ans = Math.max(ans, res);
        }
        ans = Math.max(ans, maxr[N-1]);
        for (int i = 0; i < N-1; i++) {
            long res = csum[i] - x[i]*2;
            res = res + maxr[N-i-2];
            ans = Math.max(ans, res);
        }
        // System.out.println(Arrays.toString(csum));
        // System.out.println(Arrays.toString(csumr));
        // System.out.println(Arrays.toString(val));
        // System.out.println(Arrays.toString(var));
        // System.out.println(Arrays.toString(maxl));
        // System.out.println(Arrays.toString(maxr));
        out.println(Math.max(ans,0));
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