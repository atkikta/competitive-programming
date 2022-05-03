import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int M = ni();
        int K = ni();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = ni();
        }
        int[] b = new int[M];
        for (int i = 0; i < M; i++) {
            b[i] = ni();
        }
        long[] csuma = new long[N+1];
        for (int i = 1; i < N+1; i++) {
            csuma[i] = csuma[i-1] + a[i-1];
        }
        long[] csumb = new long[M+1];
        for (int i = 1; i < M+1; i++) {
            csumb[i] = csumb[i-1] + b[i-1];
        }
        // System.out.println(Arrays.toString(csuma));
        // System.out.println(Arrays.toString(csumb));
        int left = 0;
        int right = N+M+1;
        while(left<right-1){
            int mid = (left+right)/2;
            boolean readble = false;
            for (int i = 0; i <= mid; i++) {
                if(i>N || (mid-i)>M) continue;
                if(csuma[i] + csumb[mid-i] <= K) readble = true;
            }
            // System.out.println(String.format("%d %d %s", left, right, readble));
            if(readble) left = mid;
            else right = mid;
        }
        
        long ans = left;
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