import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int M = ni();
        ArrayList<Integer> H = new ArrayList<>();
        for (int i = 0; i < N; i++){
            H.add(ni());
        }
        ArrayList<Integer> W = new ArrayList<>();
        for (int i = 0; i < M; i++){
            W.add(ni());
        }
        Collections.sort(H);
        Collections.sort(W);
        BinarySearch<Integer> bs = new BinarySearch<>();
        long diff = 0;
        for (int i = 1; i < N; i++) {
            if(i%2==1) diff -= H.get(i);
            else diff += H.get(i);
        }
        int lr = Math.min(M-1, bs.lowerBound(W, H.get(0)));
        int ll = Math.max(0, lr-1);
        int rr = Math.min(M-1, bs.upperBound(W, H.get(0)));
        int rl = Math.max(0,rr-1);
        long ans = diff + Math.abs(H.get(0) - W.get(ll));
        ans = Math.min(ans, diff + Math.abs(H.get(0) - W.get(lr)));
        ans = Math.min(ans, diff + Math.abs(H.get(0) - W.get(rl)));
        ans = Math.min(ans, diff + Math.abs(H.get(0) - W.get(rr)));

        for (int i = 1; i < N; i++) {
            if(i%2==1) diff = diff - H.get(i-1) + H.get(i);
            else       diff = diff + H.get(i-1) - H.get(i);
            lr = Math.min(M-1, bs.lowerBound(W, H.get(i)));
            ll = Math.max(0, lr-1);
            rr = Math.min(M-1,bs.upperBound(W, H.get(i)));
            rl = Math.max(0,rr-1);
            ans = Math.min(ans, diff + Math.abs(H.get(i) - W.get(ll)));
            ans = Math.min(ans, diff + Math.abs(H.get(i) - W.get(lr)));
            ans = Math.min(ans, diff + Math.abs(H.get(i) - W.get(rl)));
            ans = Math.min(ans, diff + Math.abs(H.get(i) - W.get(rr)));

            // System.out.println(String.format("%d %d %d %d", ll, lr, rl, rr));
            // System.out.println(String.format("%d %d", i, ans));
        }

        out.println(ans);
    }
    class BinarySearch<T extends Comparable<? super T>>{
        int upperBound(ArrayList<T> list, T target){
            int i = Collections.binarySearch(list, target, (x,y)->(x.compareTo(y) > 0) ? 1 : -1);
            return ~i;
        }
        int lowerBound(ArrayList<T> list, T target){
            int i = Collections.binarySearch(list, target, (x,y)->(x.compareTo(y) >= 0) ? 1 : -1);
            return ~i;
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