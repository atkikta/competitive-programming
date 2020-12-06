import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int t = ni();
        for (int i = 0; i < t; i++) {
            
            int ax = ni();
            int ay = ni();
            int bx = ni();
            int by = ni();
            int cx = ni();
            int cy = ni();
     
            long ans = 0;
            if(ax<0||bx<0||cx<0) ans++;
            if(ay<0||by<0||cy<0) ans++;
            ax = Math.abs(ax);
            ay = Math.abs(ay);
            bx = Math.abs(bx);
            by = Math.abs(by);
            cx = Math.abs(cx);
            cy = Math.abs(cy);
    
            int minx = Math.min(ax, Math.min(bx, cx));
            int miny = Math.min(ay, Math.min(by, cy));
            if(minx>0&&miny>0)ans += (minx+miny)*2-1;
            else ans += (minx+miny)*2;
            
            int maxx = Math.max(ax, Math.max(bx, cx));
            int maxy = Math.max(ay, Math.max(by, cy));
            if(minx>0&&miny>0){
                if((maxx==ax&&maxy==ay)||(maxx==bx&&maxy==by)||(maxx==cx&&maxy==cy)){
                    ans++;
                }
            }else if(miny==0){
                if((maxx==ax&&maxx==bx)||(maxx==cx&&maxx==bx)||(maxx==ax&&maxx==cx)){
                    ans++;
                }
            }else if(minx==0){
                if((maxy==ay&&maxy==by)||(maxy==cy&&maxy==by)||(maxy==ay&&maxy==cy)){
                    ans++;
                }
            }
            out.println(ans);
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