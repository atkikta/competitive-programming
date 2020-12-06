import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        s = ns();
        BitSearch bs = new BitSearch(s.length()-1);
 
        long ans = bs.search();
        out.println(ans);
    }
    class BitSearch{
        int N;
        BitSearch(int N){
            this.N = N;
        }
        long search(){
            long res = 0;
            for (int i = 1; i < (1<<N); i++) {
                // System.out.println(String.format("i: %d", i));
                long val = 0;
                int at = 0;
                for (int j = 0; j < s.length()-1; j++) {
                    if(((i>>j)&1)==1){
                        // System.out.println(j);
                        // System.out.println(s.substring(at, j+1));
                        val += Long.valueOf(s.substring(at, j+1));
                        at = j+1;
                    }
                }
                // System.out.println(s.substring(at, s.length()));
                val += Long.valueOf(s.substring(at, s.length()));
                res += val;
            }
            return res + Long.valueOf(s);
        }
    }
    String s;
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