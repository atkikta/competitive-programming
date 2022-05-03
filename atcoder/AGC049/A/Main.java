import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        a = new int[N][N];
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            String s = ns();
            for (int j = 0; j < N; j++) {
                if(s.charAt(j)=='1') a[i][j] = 1;
                uf.union(i,j);
            }
        }
        fromlist = new HashMap<>();
        for (int i = 0; i < N; i++) {
            fromlist.put(i, new ArrayList<>());
            visited = new int[N];
            fromlist.get(i).add(i);
            dfs2(i, i);
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int parent = uf.find(i);
            map.putIfAbsent(parent, new ArrayList<>());
            map.get(parent).add(i);
        }
        for (ArrayList<Integer> list : map.values()) {
            vset = new HashSet<>();
            dfs(list, 0);
        }
        double ans = step/count;

        out.println(ans);
    }
    int[][] a;
    int[] visited;
    HashSet<Integer> vset;
    double step=0;
    double count=0;
    HashMap<Integer, ArrayList<Integer>> fromlist;
    void dfs2(int node, int source){
        visited[node] = 1;
        for (int i = 0; i < a.length; i++) {
            if(a[node][i]==1 && visited[i]==0) {
                fromlist.get(source).add(i);
                dfs2(i, source);
            }
        }
    }
    void dfs(ArrayList<Integer> list, int s){
        if(list.size()==vset.size()){
            step += s;
            count++;
            return;
        }
        for (Integer next : list) {
            if(vset.contains(next)) continue;
            ArrayList<Integer> added = new ArrayList<>();
            for (Integer c : fromlist.get(next)) {
                if(!vset.contains(c)){
                    vset.add(c);
                    added.add(c);
                }
            }
            dfs(list, s+1);
            for (Integer c : added) vset.remove(c);
            // count++;
        }
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