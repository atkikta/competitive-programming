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
            String s = ns();
            if(s.length()==1){
                out.println(0);
                continue;
            }else if(s.length()==2){
                if(s.charAt(0)==s.charAt(1)) out.println(1);
                else out.println(0);
                continue;
            }
            else{
                int b2 = s.charAt(0) - 'a';
                int b1 = s.charAt(1) - 'a';
                int count = 0;
                int minc = 0;
                if(b2==b1){
                    count++;
                    while(minc==b2|| (1<s.length()-1 ? minc==s.charAt(2)-'a' : false) || (1<s.length()-2 ? minc==s.charAt(3)-'a' : false)){
                        minc++;
                    }
                    b1 = minc;
                }
                for (int j = 2; j < s.length(); j++) {
                    int b0 = s.charAt(j) - 'a';
                    if(b0==b1 || b0==b2){
                        count++;
                        while(minc==b1||minc==b2 || (j<s.length()-1 ? minc==s.charAt(j+1)-'a' : false) || (j<s.length()-2 ? minc==s.charAt(j+2)-'a' : false)){
                            minc = (minc+1)%26;
                        }
                        b0 = minc;
                    }
                    b2 = b1;
                    b1 = b0;
                }
                out.println(count);
            }
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