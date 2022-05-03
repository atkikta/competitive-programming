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
        int[] w = new int[N];
        int maxw = 0;
        for (int i = 0; i < N; i++){
            w[i] = ni();
            maxw = Math.max(maxw, w[i]);
        }
        int[] l = new int[M];
        int[] v = new int[M];
        int minv = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++){
            l[i] = ni();
            v[i] = ni();
            minv = Math.min(minv, v[i]);
        }
        if(maxw > minv){
            out.println(-1);
            return;
        }
        int[] mindis = new int[1<<N];
        for (int i = 0; i < 1<<N; i++) {
            int waight = 0;
            for (int j = 0; j < N; j++) {
                if(((i>>j)&1)==1){
                    waight+=w[j];
                }
            }
            int max = 0;
            for (int j = 0; j < M; j++) {
                if(waight>v[j]) max = Math.max(max, l[j]);
            }
            mindis[i] = max;
        }
        // System.out.println(Arrays.toString(mindis));
        ArrayList<ArrayList<Integer>> perm = new Permute(N).getall();
        long ans = Long.MAX_VALUE;
        for (ArrayList<Integer> p : perm) {
            int[] dist = new int[N];
            for (int i = 0; i < N; i++) {
                int left = p.get(i);
                int bit = 1<<left;
                for (int j = i+1; j < N; j++) {
                    int right = p.get(j);
                    bit = bit|1<<right;
                    dist[j] = Math.max(dist[j], dist[i]+mindis[bit]);
                }
            }
            ans = Math.min(ans, dist[N-1]);
            // out.println(Arrays.toString(dist));
        }
        out.println(ans);
    }
    class Permute{
        int n;
        ArrayList<ArrayList<Integer>> list;
        int[] visited;
        Permute(int n){
            this.n = n;
            this.list = new ArrayList<>();
            this.visited = new int[n];
            dfs(new ArrayList<Integer>());
        }
        void dfs(ArrayList<Integer> p){
            if(p.size()==n){
                list.add(new ArrayList<>(p));
                return;
            }
            for (int i = 0; i < n; i++) {
                if(visited[i]==1)continue;
                visited[i] = 1;
                p.add(i);
                dfs(p);
                visited[i] = 0;
                p.remove(p.size()-1);
            }
        }
        ArrayList<ArrayList<Integer>> getall(){
            return this.list;
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