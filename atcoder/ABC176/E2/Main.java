import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int H = ni();
        int W = ni();
        int M = ni();
        int[] rcount = new int[H];
        int[] ccount = new int[W];
        ArrayList<HashSet<Integer>> loc = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            loc.add(new HashSet<>());
        }
        for (int i = 0; i < M; i++) {
            int h = ni()-1;
            int w = ni()-1;
            loc.get(h).add(w);
            rcount[h]++;
            ccount[w]++;
        }
        int maxrowcount = 0;
        int maxcolcount = 0;
        for (int i = 0; i < H; i++) {
            if(maxrowcount<rcount[i]) maxrowcount = rcount[i];
        }
        for (int i = 0; i < W; i++) {
            if(maxcolcount<ccount[i]) maxcolcount = ccount[i];
        }
        if(maxrowcount==W&&maxcolcount==H){
            out.println(H+W-1);
            return;
        }
        int possiblemax = Math.min(H+W-1, maxcolcount + maxrowcount);
        ArrayList<Integer> rcand = new ArrayList<>();
        ArrayList<Integer> ccand = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            if(rcount[i]==maxrowcount)rcand.add(i);
        }
        for (int i = 0; i < W; i++) {
            if(ccount[i]==maxcolcount)ccand.add(i);
        }
        for (Integer i: rcand) {
            for (Integer j: ccand) {
                if(!loc.get(i).contains(j)){
                    out.println(maxrowcount+maxcolcount);
                    return;
                }
            }
        }
 
        long ans = maxrowcount+maxcolcount-1;
        out.println(ans);
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