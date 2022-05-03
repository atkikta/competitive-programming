import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        String s = ns();
        boolean start0 = true;
        if(s.equals("1")){
            out.println("20000000000");
            return;
        }else if(s.equals("0")){
            out.println("10000000000");
            return;
        }
        for (int i = 0; i < N; i++) {
            if(i%3==0 && s.charAt(i)!='1') start0=false;
            if(i%3==1 && s.charAt(i)!='1') start0=false;
            if(i%3==2 && s.charAt(i)!='0') start0=false;
        }
        boolean start1 = true;
        for (int i = 0; i < N; i++) {
            if(i%3==0 && s.charAt(i)!='1') start1=false;
            if(i%3==1 && s.charAt(i)!='0') start1=false;
            if(i%3==2 && s.charAt(i)!='1') start1=false;
        }
        boolean start2 = true;
        for (int i = 0; i < N; i++) {
            if(i%3==0 && s.charAt(i)!='0') start2=false;
            if(i%3==1 && s.charAt(i)!='1') start2=false;
            if(i%3==2 && s.charAt(i)!='1') start2=false;
        }

        if(start0){
            long firstset = (N+2)/3;
            long ans = 10000000000L - (firstset-1);
            out.println(ans);
        }else if(start1){
            long firstset = (N+3)/3;
            long ans = 10000000000L - (firstset-1);
            out.println(ans);
        }else if(start2){
            long firstset = (N+4)/3;
            long ans = 10000000000L - (firstset-1);
            out.println(ans);
        }else{
            out.println(0);
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