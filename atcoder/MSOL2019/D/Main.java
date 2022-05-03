import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        ArrayList<ArrayList<Integer>> adja = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adja.add(new ArrayList<>(Arrays.asList(i,0)));
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        ArrayList<Integer> c = new ArrayList<>();
        for (int i = 0; i < N-1; i++) {
            int A = ni()-1;
            int B = ni()-1;
            graph.get(A).add(B);
            graph.get(B).add(A);
        }
        for (int i = 0; i < N; i++) {
            c.add(ni());
        }
        Collections.sort(c,Comparator.reverseOrder());
        int[] score = new int[N];
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int count = 0;
        score[0] = c.get(count);
        count++;
        que.add(0);
        long ans = 0;
        while(que.size()>0){
            int node = que.poll();
            for (Integer next : graph.get(node)) {
                if(score[next] == 0){
                    score[next] = c.get(count);
                    ans += c.get(count);
                    count++;
                    que.addLast(next);
                }
            }
        }
        out.println(ans);
        for (int i = 0; i < score.length; i++) {
            out.print(score[i]);
            out.print(" ");
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