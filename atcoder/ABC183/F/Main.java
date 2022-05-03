import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
        UnionFind uf = new UnionFind(N, c);
        for (int i = 0; i < Q; i++) {
            int type = ni();
            if(type==1){
                int a = ni()-1;
                int b = ni()-1;
                uf.union(a, b);
            }else{
                int x = ni()-1;
                int y = ni();
                out.println(uf.query(x, y));
            }
        }
    }
    class UnionFind{
        int[] par;
        ArrayList<HashMap<Integer, Integer>> cls = new ArrayList<>();
        UnionFind(int n, int[] c){
            par = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = -1;
                cls.add(new HashMap<>());
            }
            for (int i = 0; i < n; i++) {
                cls.get(i).put(c[i],1);
                
            }
        }
        int find (int n){
            if(par[n] < 0){
                return n;
            }else{
                return find(par[n]);
            }
        }
        int query(int x, int y){
            int p = find(x);
            if(cls.get(p).containsKey(y)) return cls.get(p).get(y);
            else return 0;
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
            for (Integer c : cls.get(b).keySet()) {
                cls.get(a).putIfAbsent(c, 0);
                cls.get(a).put(c, cls.get(a).get(c)+ cls.get(b).get(c));
            }
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