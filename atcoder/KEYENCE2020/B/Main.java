import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        ArrayList<ArrayList<Integer>> robo = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = ni();
            int l = ni();
            ArrayList<Integer> r = new ArrayList<>();
            r.add(x-l);
            r.add(x+l);
            robo.add(r);
        }
        Collections.sort(robo, (r1,r2) -> r1.get(1).compareTo(r2.get(1)));
        // System.out.println(robo);
        int time = -Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if(time <= robo.get(i).get(0)){
                time = robo.get(i).get(1);
                ans ++;
            }
        }
        out.println(ans);
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