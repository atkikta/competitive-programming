import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        double[] m = new double[N];
        double[] M = new double[N];
        for (int i = 0; i < N; i++) {
            M[i] = nd();
            m[i] = nd();
        }
        int mo = 0;
        int ma = 0;
        int na = 0;
        int ne = 0;
        int fu = 0;
        int mf = 0;
        for (int i = 0; i < N; i++) {
            if(M[i]>=35) mo++;
            if(M[i]>=30 && M[i]<35) ma++;
            if(M[i]>=25 && M[i]<30) na++;
            if(m[i]>=25) ne++;
            if(m[i]<0 && M[i]>=0) fu++;
            if(M[i]<0) mf++;
        }
 
        out.println(String.format("%d %d %d %d %d %d", mo, ma,na,ne,fu,mf));
    }

    final int mod = 1000000007;
    final BigInteger MOD = BigInteger.valueOf(mod);
    int upperBound(ArrayList<Long> list, Long target){
        int i = Collections.binarySearch(list, target, new UpperBoundComparator<Long>());
        return ~i;
    }
    class UpperBoundComparator<T extends Comparable<? super T>> implements Comparator<T>{
        public int compare(T x, T y){
            return (x.compareTo(y) > 0) ? 1 : -1;
        }
    }
    int lowerBound(ArrayList<Long> list, Long target){
        int i = Collections.binarySearch(list, target, new LowerBoundComparator<Long>());
        return ~i;
    }
    class LowerBoundComparator<T extends Comparable<? super T>> implements Comparator<T>{
        public int compare(T x, T y){
            return (x.compareTo(y) >= 0) ? 1 : -1;
        }
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