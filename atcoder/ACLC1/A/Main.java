import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = ni()-1;
            int y = ni()-1;
            list.add(new ArrayList<>(Arrays.asList(x,y,i)));
        }
        Collections.sort(list, (a1,a2)->a1.get(0).compareTo(a2.get(0)));
        UnionFind uf = new UnionFind(N);
        Deque<ArrayList<Integer>> que = new ArrayDeque<>();
        ArrayList<Integer> ymin = new ArrayList<>(Arrays.asList(-1, Integer.MAX_VALUE/2, -1));
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> node = list.get(i);
            if(node.get(1) < ymin.get(1)){
                que.addFirst(ymin);
                ymin = node;
            }else{
                uf.union(ymin.get(2), node.get(2));
                while(!que.isEmpty() && que.peekFirst().get(1) < node.get(1)){
                    uf.union(node.get(2), que.peekFirst().get(2));
                    que.removeFirst();
                }
            }
        }
        for (int i = 0; i < N; i++) {
            out.println(uf.size(i));
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