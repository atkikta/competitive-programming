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
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        for (int i = 0; i < N; i++){
            list.add(new ArrayList<>());
        }
        int[] P = new int[M];
        int[] Y = new int[M];
        for (int i = 0; i < M; i++) {
            int p= ni() - 1;
            int y= ni();
            P[i] = p;
            Y[i] = y;
            list.get(p).add(y);
        }
        for (int i = 0; i < N; i++) {
            Collections.sort(list.get(i));
        }
        for (int i = 0; i < M; i++) {
            int order = lowerBound(list.get(P[i]), Y[i]) +1;
            String id = fillzero(P[i]+1) + fillzero(order);
            out.println(id);
        }
    }
    String fillzero(int val){
        String ret = "";
        int tens = 100000;
        while (tens>=1) {
            if(val>=tens){
                ret += String.valueOf(val);
                break;
            }else{
                ret += "0";
            }
            tens = tens/10;
        }
        return ret;
    }
    final int mod = 1000000007;
    final BigInteger MOD = BigInteger.valueOf(mod);
    int upperBound(ArrayList<Integer> list, Integer target){
        int i = Collections.binarySearch(list, target, new UpperBoundComparator<Integer>());
        return ~i;
    }
    class UpperBoundComparator<T extends Comparable<? super T>> implements Comparator<T>{
        public int compare(T x, T y){
            return (x.compareTo(y) > 0) ? 1 : -1;
        }
    }
    int lowerBound(ArrayList<Integer> list, Integer target){
        int i = Collections.binarySearch(list, target, new LowerBoundComparator<Integer>());
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