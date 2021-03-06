import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        String s = ns();
        long[] a = new long[s.length()];
        for (int i = 0; i < a.length; i++) {
            if(s.charAt(i)=='2') a[i] = 2;
            else if(s.charAt(i)=='5') a[i] = 5;
            else a[i] = 0;
        }
        Inchworm worm = new Inchworm(a);
        
 
        long ans = worm.walk();
        out.println(ans);
    }
    class Inchworm {
        long[] a;
        long K;
        int right = 0;
        public Inchworm(long[] a){
            this.a = a;
        }
        public long walk(){
            long res = 0;
            for (int left = 0; left < a.length; left++) {
                /* check if some condition is satisfied when right steps forward*/
                while(right+1 < a.length && (a[right]==2 && a[right+1]==5)){
                    // System.out.println(String.format("%d %d", left, right));
                    /* actually step forward */
                    right += 2;
                }
                /* do something when right is largest that statisfies the condition*/
                if((right!=left)&&(right-left)%2==0)res += (right-left)/2;

                /* do something before step left forward */
                if(left == right){ // if at the same position, step right altogether 
                    right++;
                }else{
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