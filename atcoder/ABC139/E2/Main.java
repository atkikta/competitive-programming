import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                set.add(j);
                graph.put(set, new ArrayList<>());
            }
        }
        for (int i = 0; i < N; i++) {
            int as = ni()-1;
            HashSet<Integer> snode = new HashSet<>();
            snode.add(i);
            snode.add(as);
            for (int j = 1; j < N-1; j++) {
                int at = ni()-1;
                HashSet<Integer> tnode = new HashSet<>();
                tnode.add(i);
                tnode.add(at); 
                graph.get(snode).add(tnode);
                snode = tnode;
            }
        }
        dist = new HashMap<>();
        for (HashSet node : graph.keySet()) {
            dist.add(node, Integer.MAX_VALUE);
        }

        for (Hashset node : graph.keySet()) {
            dfs(node);
        }
        int ans = 0;
        for (Integer d : dist.values()) {
            ans = Math.max(ans, d);
        }
        out.println(ans);
    }
    dfs(HashSet<Integer> node){
        for (HashSet<Integer> next : graph.get(node)) {
            
        }
    }
    HashMap<HashSet<Integer>, Integer> dist;
    HashMap<HashSet<Integer>, ArrayList<HashSet<Integer>>> graph;


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