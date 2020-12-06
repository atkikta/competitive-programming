import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
 
    void solve() throws IOException {
        int n = ni();
        int q = ni();
        graph= new ArrayList<>();
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            int a = ni()-1;
            int b = ni()-1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] point = new int[n];
        for (int i = 0; i < q; i++) {
            int p = ni()-1;
            int x = ni();
            point[p] += x;
        }
        int[]state = new int[n];
        state[0] =1;
        dfs(0,state,point);
        for (int i = 0; i < point.length; i++) {
            out.print(point[i]);
            out.print(" ");
        }
    }
    void dfs(int node, int[]state, int[]point){
        for (Integer next : graph.get(node)) {
            if(state[next] == 0){
                point[next] += point[node];
                state[next]=1;
                dfs(next, state, point);
                state[next]=0;
            }
        }
    }
    ArrayList<ArrayList<Integer>> graph;
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
        out.flush();
        out.close();
    }
}