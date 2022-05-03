import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

 
public class Main {
 
    void solve() throws IOException {
        int W = ni();
        int H = ni();
        // (H+W-2)C(H-1)
        ModComb mc = new ModComb(H+W-2, mod);
        int ans = mc.comb(H+W-2, H-1);
        out.println(ans);
    }
    public class ModComb{
        int mod;
        int N;
        int[] nfac;
        int[] nfacinv;
        ModComb(int n, int mod){
            this.mod = mod;
            final BigInteger MOD = BigInteger.valueOf(mod);
            this.N=n;
            this.nfac = new int[n+1];
            this.nfacinv = new int[n+1];
            nfac[0] = 1;
            for (int i = 1; i < n+1; i++) {
                nfac[i] = (int)((nfac[i-1] * 1L * i)%mod);
            }
            int inv = BigInteger.valueOf((long)nfac[n]).modInverse(MOD).intValue();
            this.nfacinv[n] = inv;
            for (int i = n; i > 0; i--) {
                nfacinv[i-1] = (int)((nfacinv[i] * 1L * i)%mod);
            }
        }
        int comb(int n, int r){
            int ret = (int)((nfac[n] * 1L * nfacinv[r]) % mod);
            ret = (int)((ret * 1L * nfacinv[n-r]) % mod);
            return ret;
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