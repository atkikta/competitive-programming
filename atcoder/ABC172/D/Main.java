import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int[] d = new int[N+1];
        d[1] = 1;
        d[0] = -1;
        for (int i = 2; i <= N; i++) {
            if(d[i] != 0) continue;
            d[i] = i;
            for (int j = i+i; j <= N; j+=i) {
                if(d[j] == 0) d[j] = i;
            }
        }
        long ans =0;
        for (int i = 1; i <=N; i++) {
            HashMap<Integer,Integer> res = new HashMap<>();
            int k = i;
            while(k!=1){
                res.putIfAbsent(d[k],0);
                res.put(d[k],res.get(d[k])+1);
                k /= d[k];
            }
            // System.out.println(res);
            long count = 1;
            for (Integer j : res.values()) {
                count *= (j+1);
            }
            // System.out.println(count);
            ans += i*count;
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