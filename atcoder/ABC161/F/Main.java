import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        long N = nl();
        if(N==2){
            out.println(1);
            return;
        }
        long ans = 1;
        for (long i = 2; i*i <= N; i++) {
            long n = N;
            while(n>0){
                if(n==1){
                    // System.out.println(i);
                    ans++;
                    break;
                }else if(n%i==0){
                    n=n/i;
                }else{
                    break;
                }
            }
        }
        for (long i = 1; i*i <= N-1; i++) {
            if(i*i==(N-1)){
                // System.out.println(i);
                ans+=1;
            }
            else if((N-1)%i==0){
                if(i==1){
                    ans+=1;
                    // System.out.println((N-1)/i);
                }else{
                    // System.out.println(i);
                    // System.out.println((N-1)/i);
                    ans+=2;
                }
            }
        }
        for (long x = 2; x*(x+1) <= N; x++) {
            long y = x;
            while(y<N){
                if(N%y==0 && (N/y-1)%x == 0 && (N/y-1)/x>0) {
                    // System.out.println(String.format("%d %d", y, x));
                    ans++;
                    break;
                }
                y *= x;
            }
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