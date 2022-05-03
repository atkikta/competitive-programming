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
        char[] ans = new char[N];
        for (int i = 0; i < 4; i++) {
            if(i==0){
                ans[0] = 'S';
                ans[1] = 'S';
            }else if(i==1){
                ans[0] = 'S';
                ans[1] = 'W';
            }else if(i==2){
                ans[0] = 'W';
                ans[1] = 'S';
            }else{
                ans[0] = 'W';
                ans[1] = 'W';
            }
            for (int j = 1; j < N-1; j++) {
                if(s.charAt(j)=='o' && ans[j-1]=='S' && ans[j]=='S') ans[j+1]='S';
                if(s.charAt(j)=='o' && ans[j-1]=='S' && ans[j]=='W') ans[j+1]='W';
                if(s.charAt(j)=='o' && ans[j-1]=='W' && ans[j]=='S') ans[j+1]='W';
                if(s.charAt(j)=='o' && ans[j-1]=='W' && ans[j]=='W') ans[j+1]='S';
                if(s.charAt(j)=='x' && ans[j-1]=='S' && ans[j]=='S') ans[j+1]='W';
                if(s.charAt(j)=='x' && ans[j-1]=='S' && ans[j]=='W') ans[j+1]='S';
                if(s.charAt(j)=='x' && ans[j-1]=='W' && ans[j]=='S') ans[j+1]='S';
                if(s.charAt(j)=='x' && ans[j-1]=='W' && ans[j]=='W') ans[j+1]='W';
                // System.out.println(Arrays.toString(ans));
            }
            boolean isok = false;
            if(s.charAt(N-1)=='o'){
                if(ans[N-1]=='S'&& ans[N-2]==ans[0]) isok = true;
                if(ans[N-1]=='W'&& ans[N-2]!=ans[0]) isok = true;
            }else{
                if(ans[N-1]=='S'&& ans[N-2]!=ans[0]) isok = true;
                if(ans[N-1]=='W'&& ans[N-2]==ans[0]) isok = true;
            }
            boolean isok2 = false;
            if(s.charAt(0)=='o'){
                if(ans[0]=='S'&& ans[N-1]==ans[1]) isok2 = true;
                if(ans[0]=='W'&& ans[N-1]!=ans[1]) isok2 = true;
            }else{
                if(ans[0]=='S'&& ans[N-1]!=ans[1]) isok2 = true;
                if(ans[0]=='W'&& ans[N-1]==ans[1]) isok2 = true;
            }
            if(isok&&isok2){
                for (int j = 0; j < N; j++) {
                    out.print(ans[j]);
                }
                out.println();
                return;
            }
        }
 
        out.println(-1);
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