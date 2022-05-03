import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int M = ni();
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        int[] before = new int[N];
        int[] incount = new int[N];
        Arrays.fill(before, -1); 
        for (int i = 0; i < N-1+M; i++) {
            int A = ni()-1;
            int B = ni()-1;
            graph.get(A).add(B);
            before[B] = A;
            incount[B]++;
        }
        int root = 0;
        for (int i = 0; i < before.length; i++) {
            if(before[i]==-1) root = i;
        }
        int[] dist = new int[N];
        Arrays.fill(dist, -1);
        int[] parent = new int[N];
        parent[root] = -1;
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(root);
        dist[root] = 0;
        while(que.size()>0){
            int now = que.poll();
            for (Integer next : graph.get(now)) {
                incount[next]--;
                if(dist[next]==-1 || dist[next] < dist[now] + 1){
                    dist[next] = dist[now] + 1;
                    parent[next] = now;
                }
                if(incount[next]==0)que.add(next);
            }
        }
        for (int i = 0; i < N; i++) {
            out.println(parent[i]+1);
        }
    }
    ArrayList<ArrayList<Integer>> graph;
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