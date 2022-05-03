import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int A = ni();
        int B = ni();
        int Q = ni();
        ArrayList<Long> s = new ArrayList<>();
        ArrayList<Long> t = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            s.add(nl());
        }
        for (int i = 0; i < B; i++) {
            t.add(nl());
        }
        s.add(Long.MIN_VALUE/10);
        s.add(Long.MAX_VALUE/10);
        t.add(Long.MIN_VALUE/10);
        t.add(Long.MAX_VALUE/10);
        Collections.sort(s);
        Collections.sort(t);
        BinarySearch<Long> bs = new BinarySearch<>();
        for (int i = 0; i < Q; i++) {
            long x = nl();
            int sl = bs.lowerBound(s, x)-1;
            int sr = bs.lowerBound(s, x);
            int tl = bs.lowerBound(t, x)-1;
            int tr = bs.lowerBound(t, x);
            // System.out.println(String.format("%d %d %d %d", sl, sr, tl, tr));
            long ans = Long.MAX_VALUE;
            ans = Math.min(ans, Math.abs(x-s.get(sl))+Math.abs(s.get(sl)-t.get(tl)));
            ans = Math.min(ans, Math.abs(x-s.get(sl))+Math.abs(s.get(sl)-t.get(tr)));
            ans = Math.min(ans, Math.abs(x-s.get(sr))+Math.abs(s.get(sr)-t.get(tl)));
            ans = Math.min(ans, Math.abs(x-s.get(sr))+Math.abs(s.get(sr)-t.get(tr)));
            ans = Math.min(ans, Math.abs(x-t.get(tl))+Math.abs(t.get(tl)-s.get(sr)));
            ans = Math.min(ans, Math.abs(x-t.get(tl))+Math.abs(t.get(tl)-s.get(sl)));
            ans = Math.min(ans, Math.abs(x-t.get(tr))+Math.abs(t.get(tr)-s.get(sl)));
            ans = Math.min(ans, Math.abs(x-t.get(tr))+Math.abs(t.get(tr)-s.get(sr)));
            out.println(ans);
        }
 
    }
    class BinarySearch<T extends Comparable<? super T>>{
        int upperBound(ArrayList<T> list, T target){
            int i = Collections.binarySearch(list, target, (x,y)->(x.compareTo(y) > 0) ? 1 : -1);
            return ~i;
        }
        int lowerBound(ArrayList<T> list, T target){
            int i = Collections.binarySearch(list, target, (x,y)->(x.compareTo(y) >= 0) ? 1 : -1);
            return ~i;
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