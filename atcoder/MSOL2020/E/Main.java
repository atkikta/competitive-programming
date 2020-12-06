import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        n = ni();
        x = new int[n];
        y = new int[n];
        p = new int[n];
        ArrayList<ArrayList<Integer>> towns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x[i] = ni();
            y[i] = ni();
            p[i] = ni();
            towns.add(new ArrayList<>(Arrays.asList(x[i],y[i],p[i])));
        }
        Collections.sort(towns, (xx,yy) -> (yy.get(2).compareTo(xx.get(2))));
        ArrayList<Integer> xrail = new ArrayList<>();
        xrail.add(0);
        ArrayList<Integer> yrail = new ArrayList<>();
        yrail.add(0);

        long score = score(xrail, yrail);
        out.println(score);
        for (int i = 1; i <= n; i++) {
            long minscore = Long.MAX_VALUE;
            for (int j = 0; j < (1<<i); j++) {
                ArrayList<Integer> xr = new ArrayList<>();
                ArrayList<Integer> yr = new ArrayList<>();
                xr.add(0);
                yr.add(0);
                for (int k = 0; k < i; k++) {
                    if((j>>(k-1)) ==0){
                        yr.add(towns.get(k).get(1));
                        // xr.add(0);
                    }else{
                        xr.add(towns.get(k).get(0));
                        // yr.add(0);
                    }
                }
                minscore = Math.min(minscore, score(xr,yr));
            }
            out.println(minscore);
        }
    }
    int n;
    int[] x;
    int[] y;
    int[] p;
    long score(ArrayList<Integer>xrail, ArrayList<Integer> yrail){
        long score = 0;
        for (int j = 0; j < n; j++) {
            long mindis = 30000;
            for (int k = 0; k < xrail.size(); k++) {
                mindis = Math.min(mindis,Math.abs(x[j]-xrail.get(k)));
            }
            for (int k = 0; k < yrail.size(); k++) {
                mindis = Math.min(mindis,Math.abs(y[j]-yrail.get(k)));
            }
            score += mindis * p[j];
        }
        return score;
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