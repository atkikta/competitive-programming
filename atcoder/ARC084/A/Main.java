import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            a.add(ni());
        }
        for (int i = 0; i < N; i++) {
            b.add(ni());
        }
        for (int i = 0; i < N; i++) {
            c.add(ni());
        }
        Collections.sort(b);
        Collections.sort(c);
        long[] bcount = new long[N+1];
        long[] ccount = new long[N];
        BinarySearch<Integer> bs = new BinarySearch<>();
        for (int i = 0; i < N; i++) {
            ccount[i] = N - bs.upperBound(c, b.get(i));
        }
        for (int i = 0; i < N; i++) {
            bcount[N-i-1] = bcount[N-i] + ccount[N-i-1];
        }
        // System.out.println(Arrays.toString(bcount));
        // System.out.println(Arrays.toString(ccount));
        long ans = 0;
        for (int i = 0; i < N; i++) {
            int bindex = bs.upperBound(b, a.get(i));
            // System.out.println(bindex);
            ans += bcount[bindex];
        }
        out.println(ans);
    }
    public class BinarySearch<T extends Comparable<? super T>>{
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