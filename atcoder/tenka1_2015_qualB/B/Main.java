import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        String S = ns();
        if(S.equals("{}")){
            out.println("dict");
            return;
        }
        // String type = dfs(S);
        int level = 0;
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)=='{') level++;
            if(S.charAt(i)=='}') level--;
            if(level == 1 && S.charAt(i)==':'){
                out.println("dict");
                return;
            }
        }
        out.println("set");
    }
    // String dfs(String s){
    //     int nlb = 0;
    //     int nrb = 0;
    //     int ncl = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         if(s.charAt(i)=='{') nlb++;
    //         if(s.charAt(i)=='}') nrb++;
    //         if(s.charAt(i)==':') ncl++;
    //     }
    //     if(nlb==0&&nrb==0) return "integer";
    //     else if(nlb==1 && nrb==1 && ncl==1) return "dict";
    //     else if(nlb==1 && nrb==1 && ncl==0) return "set";
    //     for (String next : s.substring(1, s.length()).split(",")) {
    //         String ntype = dfs(next);

    //     }
    // }
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