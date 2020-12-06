import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = ni();
        }
        long[] s_mon = new long[N+1];
        long[] s_sto = new long[N+1];
        long[] b_mon = new long[N+1];
        long[] b_sto = new long[N+1];
        
        s_mon[0] = 1000;
        s_sto[0] = 0;
        b_mon[0] = 0;
        b_sto[0] = 0;
        for (int i = 1; i <=N; i++) {
            s_mon[i] = Math.max(b_sto[i-1] * A[i-1] + b_mon[i-1], s_mon[i-1]);
            s_sto[i] = 0;
            if(b_mon[i-1] + b_sto[i-1]*A[i-1] >= s_mon[i-1] + s_sto[i-1]*A[i-1]){
                b_mon[i] = b_mon[i-1];
                b_sto[i] = b_sto[i-1];
            }else{
                b_mon[i] = s_mon[i-1] - (s_mon[i-1]/A[i-1]) * A[i-1];
                b_sto[i] = s_sto[i-1] + s_mon[i-1]/A[i-1];
            }
            // System.out.println(s_mon[i]);
            // System.out.println(s_sto[i]);
            // System.out.println(b_mon[i]);
            // System.out.println(b_sto[i]);
        }
        long ans = s_mon[N];
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