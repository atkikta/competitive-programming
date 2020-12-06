import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        N = ni();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = ni();
            y[i] = ni();
        }
        combination = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            dfs(list);
        }
        int ans = 0;
        for (var list : combination) {
            int x0 = x[list.get(0)];
            int x1 = x[list.get(1)];
            int x2 = x[list.get(2)];
            int y0 = y[list.get(0)];
            int y1 = y[list.get(1)];
            int y2 = y[list.get(2)];
            
            long area = Math.abs((x1-x0)*1L*(y2-y0) - (y1-y0)*1L*(x2-x0));
            if(area == 0)continue;
            if((area)%2==0 || (area)%2==0) ans++;
        }
        out.println(ans);
    }
    int N;
    ArrayList<ArrayList<Integer>> combination;
    void dfs(ArrayList<Integer> curr){
        if(curr.size()>=3) combination.add(curr);
        else{
            for (int i = curr.get(curr.size()-1)+1 ; i < N; i++) {
                ArrayList<Integer> next = (ArrayList<Integer>)curr.clone();
                next.add(i);
                dfs(next);
            }
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