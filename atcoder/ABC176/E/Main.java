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
        ArrayList<ArrayList<Integer>> rcount = new ArrayList<>();
        HashSet<ArrayList<Integer>> pair = new HashSet<>();
        for (int i = 0; i < H; i++) {
            rcount.add(new ArrayList<Integer>(Arrays.asList(0,i)));
        }
        ArrayList<ArrayList<Integer>> ccount = new ArrayList<>();
        for (int i = 0; i < W; i++) {
            ccount.add(new ArrayList<Integer>(Arrays.asList(0,i)));
        }
        int[] h = new int[M];
        int[] w = new int[M];
        for (int i = 0; i < M; i++) {
            int hh = ni()-1;
            int ww = ni()-1;
            h[i] = hh;
            w[i] = ww;
            rcount.get(hh).set(0, rcount.get(hh).get(0)+1);
            ccount.get(ww).set(0, ccount.get(ww).get(0)+1);
            pair.add(new ArrayList<Integer>(Arrays.asList(hh,ww)));
        }
        Collections.sort(rcount, (x,y)->y.get(0).compareTo(x.get(0)));
        Collections.sort(ccount, (x,y)->y.get(0).compareTo(x.get(0)));
        int maxr = rcount.get(0).get(0);
        int maxc = ccount.get(0).get(0);
        long ans = maxr + maxc;
        boolean hasUncloss = false;
        for (int i = 0; i < H; i++) {
            if(rcount.get(i).get(0) == maxr){
                for (int j = 0; j < W; j++) {
                    if(ccount.get(j).get(0) == maxc){
                        // System.out.println(rcount.get(i).get(1));
                        // System.out.println(ccount.get(j).get(1));
                        if(!pair.contains(new ArrayList<Integer>(
                            Arrays.asList(rcount.get(i).get(1),ccount.get(j).get(1))))
                            ){
                            out.println(ans);
                            return;
                        }
                    }else{
                        break;
                    }
                }
            }else{
                break;
            }
        }
        out.println(ans-1);
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