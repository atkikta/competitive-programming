import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int Q = ni();
        int[] c = new int[N];
        for (int i = 0; i < N; i++) {
            c[i] = ni();
        }
        int[] pos = new int[N+1];
        Arrays.fill(pos,-1);
        ArrayList<ArrayList<Integer>> st = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            int l = pos[c[i]];
            if(pos[c[i]]!=-1)st.get(l).add(i);
            pos[c[i]] = i;
        }
        ArrayList<ArrayList<ArrayList<Integer>>> qs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            qs.add(new ArrayList<>());
        }
        for (int i = 0; i < Q; i++) {
            int l = ni()-1;
            int r = ni()-1;
            qs.get(l).add(new ArrayList<>(Arrays.asList(r, i)));
        }
        FenwickTree ft = new FenwickTree(N);
        int[] ans = new int[Q];
        for (int i = N-1; i >=0; i--) {
            for (Integer t : st.get(i)) {
                ft.add(t,1);
            }
            for (ArrayList<Integer> q : qs.get(i)) {
                int r = q.get(0);
                ans[q.get(1)] = (r-i+1) - (int)ft.sum(r+1);
            }
        }
        // System.err.println(qs);
 
        for (int i = 0; i < ans.length; i++) {
            out.println(ans[i]);
        }
    }
    class FenwickTree{
        private int _n;
        private long[] data;
    
        public FenwickTree(int n){
            this._n = n;
            data = new long[n];
        }
    
        /**
         * @verified https://atcoder.jp/contests/practice2/tasks/practice2_b
         * @submission https://atcoder.jp/contests/practice2/submissions/16580495
         */
        public FenwickTree(long[] data) {
            this(data.length);
            build(data);
        }
    
        public void set(int p, long x){
            add(p, x - get(p));
        }
    
        public void add(int p, long x){
            assert(0<=p && p<_n);
            p++;
            while(p<=_n){
                data[p-1] += x;
                p += p&-p;
            }
        }
        public long sum(int l, int r){
            assert(0<=l && l<=r && r<=_n);
            return sum(r)-sum(l);
        }
    
        public long get(int p){
            return sum(p, p+1);
        }
    
        private long sum(int r){
            long s = 0;
            while(r>0){
                s += data[r-1];
                r -= r&-r;
            }
            return s;
        }
    
        private void build(long[] dat) {
            System.arraycopy(dat, 0, data, 0, _n);
            for (int i=1; i<=_n; i++) {
                int p = i+(i&-i);
                if(p<=_n){
                    data[p-1] += data[i-1];
                }
            }
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