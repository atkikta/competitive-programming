import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int M = ni();
        graph = new HashMap<>();
        int[] A = new int[M];
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            int a = ni();
            int b = ni();
            A[i] = a;
            B[i] = b;
            graph.putIfAbsent(a, new HashSet<>());
            graph.get(a).add(b);
            graph.putIfAbsent(b, new HashSet<>());
            graph.get(b).add(a);
        }
        int ans = 0;
        for (int i = 0; i < M; i++) {
            graph.get(A[i]).remove(B[i]);
            graph.get(B[i]).remove(A[i]);
            visited = new HashSet<>();
            dfs(1);
            // System.out.println(visited.toString());
            if(visited.size()<N) ans ++;
            graph.get(A[i]).add(B[i]);
            graph.get(B[i]).add(A[i]);
        }
        out.println(ans);
    }
    HashSet<Integer> visited;
    HashMap<Integer, HashSet<Integer>> graph;
    void dfs(int cur){
        visited.add(cur);
        if(!graph.containsKey(cur))return;
        for (Integer next : graph.get(cur)) {
            if(visited.contains(next))continue;
            else dfs(next);
        }
    }

    final int mod = 1000000007;
    int mul(int x, int y){
        return (int)((x * 1L * y) % mod);
    }
    int add(int x, int y) {
        x += y;
        return x >= mod ? (x - mod) : x;
    }
    int sub(int x, int y){
        x = add(x,mod-y);
        return x >= mod ? (x - mod) : x;
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