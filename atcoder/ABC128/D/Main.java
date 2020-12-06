import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int K = ni();
        int[] a = new int[N];
        int[] negl = new int[N];
        int[] negr = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = ni();
        }
        for (int i = 0; i < N; i++) {
            if(i>0){
                negl[i] = negl[i-1];
            }
            if(a[i]<0){
                negl[i]++;
            }
        }
        for (int i = N-1; i >=0; i--) {
            if(i<N-1){
                negr[i] = negr[i+1];
            }
            if(a[i]<0){
                negr[i]++;
            }
        }
        
        long res = Long.MIN_VALUE;
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= K; j++) {
                int ans = 0;
                PriorityQueue<Integer> que = new PriorityQueue<>((x,y)-> x.compareTo(y));
                if(i+j<=N && i+j<=K){
                    for (int ii = 0; ii < i; ii++) {
                        if(a[ii]<0) que.add(a[ii]);
                        ans += a[ii];
                    }
                    for (int jj = 0; jj < j; jj++) {
                        if(a[N-1-jj]<0) que.add(a[N-1-jj]);
                        ans += a[N-1-jj];
                    }
                    for (int k = 0; k < K-i-j; k++) {
                        if(!que.isEmpty())ans -= que.poll();
                    }
                }
                res = Math.max(res,ans);
            }
        }
        if(res == Long.MIN_VALUE) res = 0;
        out.println(res);
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