import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        String s = ns();
        int point = 0;
        int last = -1;
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i)=='R' && s.charAt(i+1)=='L'){
                point = i;
            }
            if((s.charAt(i)=='L' && s.charAt(i+1)=='R')){
                int size = i-last;
                if(size%2==0){
                    ans[point] = size/2;
                    ans[point+1] = size/2;
                }else{
                    if((point - last)%2==0){
                        ans[point] = size/2;
                        ans[point+1] = size/2+1;
                    }else{
                        ans[point] = size/2+1;
                        ans[point+1] = size/2;
                    }
                }
                last = i;
            }
            if(i==s.length()-2){
                if(s.charAt(i+1)=='R'){
                    ans[i] = i-last;
                }else{
                    int size = i-last+1;
                    // System.out.println(size);
                    if(size%2==0){
                        ans[point] = size/2;
                        ans[point+1] = size/2;
                    }else{
                        if((point - last)%2==0){
                            ans[point] = size/2;
                            ans[point+1] = size/2+1;
                        }else{
                            ans[point] = size/2+1;
                            ans[point+1] = size/2;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < ans.length; i++) {
            out.print(ans[i]);
            if(i<ans.length-1) out.print(" ");
        }
        out.println();
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