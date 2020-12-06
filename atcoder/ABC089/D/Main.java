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
        int D = ni();
        int[][] A = new int[H][W];
        int[] h = new int[H*W];
        int[] w = new int[H*W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int a = ni()-1;
                A[i][j] = a;
                h[a] = i;
                w[a] = j;
            }
        }
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < D; i++) {
            int size = (H*W-1-i)/D + 1;
            int[] arr = new int[size];
            for (int j = 1; j < arr.length; j++) {
                int from = (j-1)*D+i;
                int to   = j*D+i;
                // System.out.println(String.format("%d %d %d", i, from, to));
                arr[j] = Math.abs(h[from]-h[to]) + Math.abs(w[from]-w[to]);
            }
            for (int j = 1; j < arr.length; j++) {
                arr[j] = arr[j] + arr[j-1];
            }
            map.put(i, arr);
        }
        int Q = ni();
        for (int i = 0; i < Q; i++) {
            long ans = 0;
            int l = ni()-1;
            int r = ni()-1;
            int[] csum = map.get(l%D);
            // System.out.println(Arrays.toString(csum));
            ans += csum[r/D] - csum[l/D];
            out.println(ans);
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