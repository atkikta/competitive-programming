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
        ArrayList<ArrayList<Integer>> graph  = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int A = ni()-1;
            int B = ni()-1;
            graph.get(A).add(B);
            graph.get(B).add(A);
        }
        int K = ni();
        HashMap<Integer, Integer> ctoi = new HashMap<>();
        int[] C = new int[K];
        for (int i = 0; i < K; i++) {
            int c = ni()-1;
            ctoi.put(c, i);
            C[i] = c;
        }
        long[][] dist = new long[K][K];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                dist[i][j] = Long.MAX_VALUE/2;
            }
        }
        for (int i = 0; i < K; i++) {
            ArrayDeque<Integer> que = new ArrayDeque<>();
            boolean[] visited = new boolean[N];
            long[] distfromi = new long[N];
            que.add(C[i]);
            visited[C[i]] = true;
            while(!que.isEmpty()){
                int node = que.poll();
                for (int next: graph.get(node)) {
                    if(!visited[next]){
                        visited[next] = true;
                        distfromi[next] = distfromi[node] + 1;
                        if(ctoi.containsKey(next)) dist[i][ctoi.get(next)] = distfromi[next];
                        que.add(next);
                    }
                }
            }
        }
        int nset = 1<<K;
        long dp[][] = new long[K][nset];
        for (int i = 0; i < K ; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE/2);
            dp[i][1<<i] = 0;
        }
        for (int i = 0; i < nset; i++) {
            for (int j = 0; j < K; j++) {
                if((i>>j & 1) == 0) continue;
                for (int k = 0; k < K; k++) {
                    dp[k][i | 1<<k] = Math.min(dp[k][i | 1<<k], dp[j][i] + dist[j][k]);
                }
            }
        }
        // print2DArray(dp);
        long ans = Long.MAX_VALUE/2;
        for (int i = 0; i < K; i++) {
            ans = Math.min(ans, dp[i][nset-1]);
        }
        if(ans>=Long.MAX_VALUE/2){
            out.println(-1);
            return;
        }else{
            out.println(ans+1);
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
    void print2DArray(long[][] a){
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