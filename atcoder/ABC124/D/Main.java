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
        String s = ns();
        long[] a = new long[N];
        for (int i = 0; i < N; i++) {
            if(s.charAt(i) == '1') a[i] = 1;
        }
        Inchworm inchworm = new Inchworm(a, K);
        long ans = inchworm.walk();
        out.println(ans);
    }
    class Inchworm {
        long[] a;
        long K;
        int right = 0;
        public Inchworm(long[] a, long K){
            this.a = a;
            this.K = K;
        }
        public long walk(){
            long res = 0;
            long sum = 0;
            boolean one = true;
            for (int left = 0; left < a.length; left++) {
                /* check if some condition is satisfied when right steps forward*/
                while(right < a.length && !(one && a[right]==0 && sum+1>K)){
                    // System.out.println(String.format("%d %d %d", left, right, sum));
                    /* actually step forward */
                    if(one && a[right]==0) sum++;
                    one = a[right]==1 ? true : false;
                    ++right;
                }
                /* do something when right is largest that statisfies the condition*/
                res = Math.max(res, right - left);
                // System.out.println(res);
                /* do something before step left forward */
                if(left == right){ // if at the same position, step right altogether 
                    right++;
                }else{
                    if(left+1 < a.length && (a[left] == 0 && a[left+1] == 1)) sum--;
                }
            }
            // System.out.println(res);
            return res;
        }
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