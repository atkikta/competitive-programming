import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        long W = ni();
        long[] w = new long[N];
        int[] v = new int[N];
        long w0 = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            w[i] = nl();
            v[i] = ni();
            w0 = Math.min(w0, w[i]);
        }
        long w1 = w0+1;
        long w2 = w1+1;
        long w3 = w2+1;
        ArrayList<Integer> v0 = new ArrayList<>();
        ArrayList<Integer> v1 = new ArrayList<>();
        ArrayList<Integer> v2 = new ArrayList<>();
        ArrayList<Integer> v3 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if(w[i] == w0) v0.add(v[i]);
            if(w[i] == w1) v1.add(v[i]);
            if(w[i] == w2) v2.add(v[i]);
            if(w[i] == w3) v3.add(v[i]);
        }
        Collections.sort(v0, Comparator.reverseOrder());
        Collections.sort(v1, Comparator.reverseOrder());
        Collections.sort(v2, Comparator.reverseOrder());
        Collections.sort(v3, Comparator.reverseOrder());
        int[] csmv0 = new int[v0.size()+1];
        int[] csmv1 = new int[v1.size()+1];
        int[] csmv2 = new int[v2.size()+1];
        int[] csmv3 = new int[v3.size()+1];
        for (int i = 1; i <= v0.size(); i++) {
            csmv0[i] = csmv0[i-1] + v0.get(i-1);
        }
        for (int i = 1; i <= v1.size(); i++) {
            csmv1[i] = csmv1[i-1] + v1.get(i-1);
        }
        for (int i = 1; i <= v2.size(); i++) {
            csmv2[i] = csmv2[i-1] + v2.get(i-1);
        }
        for (int i = 1; i <= v3.size(); i++) {
            csmv3[i] = csmv3[i-1] + v3.get(i-1);
        }
        // System.out.println(Arrays.toString(csmv0));
        // System.out.println(Arrays.toString(csmv1));
        // System.out.println(Arrays.toString(csmv2));
        // System.out.println(Arrays.toString(csmv3));
        // System.out.println(v0);
        // System.out.println(v1);
        // System.out.println(v2);
        // System.out.println(v3);
        long ans = 0;
        for (int i = 0; i <= v0.size(); i++) {
            for (int j = 0; j <= v1.size(); j++) {
                for (int k = 0; k <= v2.size(); k++) {
                    for (int l = 0; l <= v3.size(); l++) {
                        // System.out.println(String.format("%d %d", w0*i + w1*j + w2*k + w3*l , W));
                        if(w0*i + w1*j + w2*k + w3*l > W) continue;
                        // System.out.println(String.format("%d %d %d %d", i,j,k,l));
                        ans = Math.max(ans, csmv0[i] + csmv1[j] + csmv2[k] + csmv3[l]);
                    }
                }
            }
        }

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