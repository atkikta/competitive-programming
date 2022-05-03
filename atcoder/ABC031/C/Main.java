import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int[] a = new int[N];
        int[] even = new int[N];
        int[] odd = new int[N];
        for (int i = 0; i < N; i++){
            a[i] = ni();
            if(i%2==0) even[i] = a[i];
            else odd[i] = a[i];
        }
        int[] cseve = new int[N+1];
        int[] csodd = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            cseve[i] = cseve[i-1] + even[i-1]; 
            csodd[i] = csodd[i-1] + odd[i-1]; 
        }
        // System.out.println(Arrays.toString(cseve));
        // System.out.println(Arrays.toString(csodd));
        long ans = Integer.MIN_VALUE/2;
        for (int i = 0; i < N; i++) {
            int lat = Integer.MIN_VALUE/2;
            int maxj = 0;
            for (int j = 0; j < N; j++) {
                int latval;
                if(i<j){
                    if((i+1)%2==0) latval = cseve[j+1] - cseve[i];
                    else latval = csodd[j+1] - csodd[i];
                    if(lat < latval){
                        lat = latval;
                        maxj = j;
                    }
                }
                else if(j<i){
                    if((j+1)%2==0) latval = cseve[i+1] - cseve[j];
                    else latval = csodd[i+1] - csodd[j];
                    if(lat < latval){
                        lat = latval;
                        maxj = j;
                    }
                }
            }
            // System.out.println(String.format("%d %d", i, maxj));
            if(maxj>i) {
                if((i+1)%2==0) ans = Math.max(ans, csodd[maxj+1]-csodd[i]);
                else ans = Math.max(ans, cseve[maxj+1]-cseve[i]);
            }
            else{
                if((maxj+1)%2==0) ans = Math.max(ans, csodd[i+1]-csodd[maxj]);
                else ans = Math.max(ans, cseve[i+1]-cseve[maxj]);
            }
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