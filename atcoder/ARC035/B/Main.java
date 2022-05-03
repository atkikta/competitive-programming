import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        ArrayList<Integer> t = new ArrayList<>();
        int[] fac = new int[N+1];
        fac[1] = 1;
        for (int i = 2; i <= N; i++) {
            fac[i] = mul(fac[i-1],i); 
        }
        HashMap<Integer,Integer> count = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int ti = ni();
            t.add(ti);
            count.putIfAbsent(ti, 0);
            count.put(ti,count.get(ti)+1);
        }
        Collections.sort(t);
        long[] pen = new long[N];
        pen[0] = t.get(0);
        for (int i = 1; i < N; i++) {
            pen[i] = pen[i-1] + t.get(i);
        }
        long minpenalty = 0;
        for (int i = 0; i < N; i++) {
            minpenalty += pen[i];
        }
        
        int c = 1;
        for (int num : count.values()) {
            c = mul(c,fac[num]);
        }
        // System.out.println(count);
        // System.out.println(Arrays.toString(fac));
        out.println(minpenalty);
        out.println(c);
    }
    
    final int mod = 1000000007;
    int mul(int x, int y){
        return (int)((x * 1L * y) % mod);
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