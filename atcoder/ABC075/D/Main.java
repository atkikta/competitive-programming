import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int K = ni();
        ArrayList<ArrayList<Integer>> xi = new ArrayList<>();
        ArrayList<ArrayList<Integer>> yi = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = ni();
            int y = ni();
            xi.add(new ArrayList<>(Arrays.asList(x,i)));
            yi.add(new ArrayList<>(Arrays.asList(y,i)));
        }
        Collections.sort(xi,(a,b)->a.get(0).compareTo(b.get(0)));
        Collections.sort(yi,(a,b)->a.get(0).compareTo(b.get(0)));
        int[][] d = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(yi.get(i).get(1) == xi.get(j).get(1)) d[i][j] = 1;
            }
        }
        int[][] count = new int[N+1][N+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count[i+1][j+1] = count[i][j+1] + count[i+1][j] -count[i][j] + d[i][j];
            }
        }
        long ans = Long.MAX_VALUE;
        for (int sy = 0; sy < N+1; sy++) {
            for (int ty = sy; ty < N+1; ty++) {
                for (int sx = 0; sx < N+1; sx++) {
                    for (int tx = sx; tx < count.length; tx++) {
                        int val = count[ty][tx] - count[sy][tx] - count[ty][sx] + count[sy][sx];
                        if(val>=K){
                            long area = (xi.get(tx-1).get(0)-xi.get(sx).get(0))*1L*(yi.get(ty-1).get(0)-yi.get(sy).get(0));
                            ans = Math.min(ans,area);
                        }
                    }
                }
            }
        }
        out.println(ans);
    }

    final int mod = 1000000007;
    final BigInteger MOD = BigInteger.valueOf(mod);
    int upperBound(ArrayList<Long> list, Long target){
        int i = Collections.binarySearch(list, target, new UpperBoundComparator<Long>());
        return ~i;
    }
    class UpperBoundComparator<T extends Comparable<? super T>> implements Comparator<T>{
        public int compare(T x, T y){
            return (x.compareTo(y) > 0) ? 1 : -1;
        }
    }
    int lowerBound(ArrayList<Long> list, Long target){
        int i = Collections.binarySearch(list, target, new LowerBoundComparator<Long>());
        return ~i;
    }
    class LowerBoundComparator<T extends Comparable<? super T>> implements Comparator<T>{
        public int compare(T x, T y){
            return (x.compareTo(y) >= 0) ? 1 : -1;
        }
    }
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