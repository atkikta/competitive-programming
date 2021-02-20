import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        double X = nd();
        double Y = nd();
        double R = nd();
        BigDecimal r = BigDecimal.valueOf(R);

        int maxy = (int)(Y+R+1)+1;
        int miny = (int)(Y-R-1)-1;
        // System.out.println(String.format("%f %f %d %d", Y, R, maxy, miny));
        long ans = 0;
        for (int yi = miny; yi <= maxy; yi++) {
            if(Y+R<yi || yi<Y-R) continue;
            BigDecimal yy = BigDecimal.valueOf(yi-Y);
            BigDecimal sqd = r.multiply(r).subtract(yy.multiply(yy));
            BigDecimal rsqd =
            double rsqd = Math.sqrt(sqd);
            double dxl = X - rsqd;
            int dxll = (int)(dxl-1) -1;
            int dxlr = (int)(dxl+1) +1;
            int xl = 0;
            for (int i = dxll+1; i <=dxlr; i++) {
                if()
            }
            double dxr = X + rsqd;
            int xr = 0;
            if(X+rsqd>=0) xr = (int)(X+rsqd);
            else xr = (int)(X+rsqd-1);
            int xl = 0;
            if(X-rsqd>=0) xl = (int)(X-rsqd)+1;
            else xl = (int)(X-rsqd);
            if(xl <= xr) ans += (xr-xl+1);
            System.out.println(String.format("%d %f %d %d", yi, rsqd, xl,xr));
        }
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