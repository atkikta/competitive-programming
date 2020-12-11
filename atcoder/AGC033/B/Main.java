import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int H = ni();
        int W = ni();
        int N = ni();
        int sr = ni();
        int sc = ni();
        String S = ns();
        String T = ns();

        int lwu = 1;
        int lwd = H;
        int lwl = 1;
        int lwr = W;
        for (int i = N-1; i >=0; i--) {
            if(T.charAt(i)=='U'&&lwd<H) lwd++;
            if(T.charAt(i)=='D'&&lwu>1) lwu--;
            if(T.charAt(i)=='L'&&lwr<W) lwr++;
            if(T.charAt(i)=='R'&&lwl>1) lwl--;

            if(S.charAt(i)=='U'){
                if(lwu==lwd){
                    out.println("NO");
                    return;
                }
                if(lwu<H) lwu++;
            }
            if(S.charAt(i)=='D'){
                if(lwu==lwd){
                    out.println("NO");
                    return;
                }
                if(lwd>1) lwd--;
            }
            if(S.charAt(i)=='L'){
                if(lwr==lwl){
                    out.println("NO");
                    return;
                }
                if(lwl<W) lwl++;
            }
            if(S.charAt(i)=='R'){
                if(lwr==lwl){
                    out.println("NO");
                    return;
                }
                if(lwr>1) lwr--;
            }

            // System.out.println(String.format("%d %d %d %d", lwu, lwd, lwl, lwr));
            if(lwd<lwu || lwr <lwl){
                out.println("NO");
                return;
            }
        }
        if(lwu<=sr && sr<=lwd && lwl<=sc && sc <= lwr){
            out.println("YES");
        }else{
            out.println("NO");
        }
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