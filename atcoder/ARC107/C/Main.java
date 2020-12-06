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
        int[][] a = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = ni();
            }
        }
        int[] rowsum = new int[N];
        int[] colsum = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rowsum[i] += a[i][j];
                colsum[j] += a[i][j];
            }
        }
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                boolean ltk = true;
                for (int k = 0; k < N; k++) {
                    if(a[k][i] + a[k][j] > K) ltk = false;
                }
                if(ltk) uf.union(i, j);
            }
        }
        int ans = 1;
        HashMap<Integer, Integer> colmap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int p = uf.find(i);
            colmap.put(p, uf.size(p));
        }
        for (int i : colmap.values()) {
            for (int j = 1; j <= i; j++) {
                ans = mul(ans, j);
            }
        }
        uf = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                boolean ltk = true;
                for (int k = 0; k < N; k++) {
                    if(a[i][k] + a[j][k] > K) ltk = false;
                }
                if(ltk) uf.union(i, j);
            }
        }
        HashMap<Integer, Integer> rowmap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int p = uf.find(i);
            rowmap.put(p, uf.size(p));
        }
        for (int i : rowmap.values()) {
            for (int j = 1; j <= i; j++) {
                ans = mul(ans, j);
            }
        }
        out.println(ans);
    }
    class UnionFind{
        int[] par;
        UnionFind(int n){
            par = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = -1;
            }
        }
        int find (int n){
            if(par[n] < 0){
                return n;
            }else{
                return find(par[n]);
            }
        }
        boolean union(int a, int b){
            a = find(a);
            b = find(b);
            if(a == b) return false;
            if(par[a] > par[b]){
                int temp = b;
                b = a;
                a = temp;
            }
            par[a] += par[b];
            par[b] = a;
            return true;
        }
        int par(int n){
            return par[n];
        }
        int size(int n){
            return -par[find(n)];
        }
        boolean same(int a, int b){
            return find(a) == find(b);
        }
    }
    final int mod = 998244353;
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