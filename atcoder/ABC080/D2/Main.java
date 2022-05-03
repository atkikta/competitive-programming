import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int C = ni();
        int T = 100000;
        int[][] stime = new int[C][T+1];
        int[][] ttime = new int[C][T+1];
        for (int i = 0; i < N; i++) {
            int s = ni();
            int t = ni();
            int c = ni()-1;
            if(ttime[c][s]==1){
                ttime[c][s] = 0;
            }else{
                stime[c][s] = 1;
            }
            if(stime[c][t]==1){
                stime[c][t] = 0;
            }else{
                ttime[c][t] = 1;
            }

        }
        int[] csm = new int[T*2+2];
        for (int i = 0; i < C; i++) {
            for (int j = 0; j <= T; j++) {
                if(stime[i][j]==1)csm[j*2-1] ++;
                if(ttime[i][j]==1)csm[j*2+1] --;
            }
        }
        for (int i = 0; i < csm.length-1; i++) {
            csm[i+1] = csm[i+1] + csm[i];
        }
        long ans = 0;
        for (int i = 0; i < csm.length; i++) {
            ans = Math.max(ans, csm[i]);
        }
        // System.out.println(Arrays.toString(csm));
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