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
        int[][] T = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                T[i][j]=ni();
            }
        }
 
        IterablePermutation permutation = new IterablePermutation(N-1);
        long ans = 0;
        for (int[] p : permutation) {
            long dis = T[0][p[0]+1] + T[p[p.length-1]+1][0];
            for (int i = 1; i < p.length; i++) {
                dis += T[p[i]+1][p[i-1]+1];
            }
            if(dis == K){
                ans++;
            }
        }

        out.println(ans);
    }
    public static class IterablePermutation implements Iterable<int[]>, Iterator<int[]>
    {
        int[] a;
        boolean first = true;
    
        public IterablePermutation(int n) {
            assert n >= 1;
            a = new int[n];
            for(int i = 0;i < n;i++)a[i] = i;
        }
    
        public IterablePermutation(int... a) {
            this.a = Arrays.copyOf(a, a.length);
        }
    
        @Override
        public boolean hasNext() {
            if(first)return true;
            int n = a.length;
            int i;
            for(i = n - 2;i >= 0 && a[i] >= a[i+1];i--);
            return i != -1;
        }
    
        @Override
        public int[] next() {
            if(first) {
                first = false;
                return a;
            }
            int n = a.length;
            int i;
            for(i = n - 2;i >= 0 && a[i] >= a[i+1];i--);
            assert i != -1;
            int j;
            for(j = i + 1;j < n && a[i] < a[j];j++);
            int d = a[i]; a[i] = a[j - 1]; a[j - 1] = d;
            for(int p = i + 1, q = n - 1;p < q;p++,q--){
                d = a[p]; a[p] = a[q]; a[q] = d;
            }
            return a;
        }
    
        @Override
        public Iterator<int[]> iterator() {
            return this;
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