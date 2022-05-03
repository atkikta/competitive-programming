import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> len = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
            len.add(new ArrayList<>());
        }
        for (int i = 0; i < N-1; i++) {
            int u = ni()-1;
            int v = ni()-1;
            int w = ni();
            graph.get(u).add(v);
            graph.get(v).add(u);
            len.get(u).add(w);
            len.get(v).add(w);
        }
        ArrayDeque<Integer> que = new ArrayDeque<>();
        long[] distance = new long[N];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;
        que.add(0);
        while(que.size()>0){
            int u = que.poll();
            for (int i = 0; i < graph.get(u).size(); i++) {
                int to = graph.get(u).get(i);
                int ln =   len.get(u).get(i);
                if(distance[to] > distance[u] + ln){
                    distance[to] = distance[u] + ln;
                    que.add(to);
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            if(distance[i] % 2 == 0) out.println(0);
            else out.println(1);
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