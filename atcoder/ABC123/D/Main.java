import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int X = ni();
        int Y = ni();
        int Z = ni();
        int K = ni();
        A = new ArrayList<>();
        B = new ArrayList<>();
        C = new ArrayList<>();
        for (int i = 0; i < X; i++) {
            A.add(nl());
        }
        for (int i = 0; i < Y; i++) {
            B.add(nl());
        }
        for (int i = 0; i < Z; i++) {
            C.add(nl());
        }
        Collections.sort(C);
        long left = 0L;
        long right = 30_000_000_001L;
        while(left < right -1){
            long mid = (left + right) / 2;
            long nlt = countMoreThan(mid);
            // System.out.println(String.format("%d %d %d", left, right, nlt));
            if(nlt < K) right = mid;
            else left = mid;
        }

        long border = left;
        PriorityQueue<Long> que = new PriorityQueue<>(Comparator.reverseOrder());
        Collections.sort(A, Comparator.reverseOrder());
        Collections.sort(B, Comparator.reverseOrder());
        Collections.sort(C, Comparator.reverseOrder());
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                for (int k = 0; k < Z; k++) {
                    long val = A.get(i) + B.get(j) + C.get(k);
                    if(val < border+1) break;
                    else que.add(val);
                }
            }
        }
        while(que.size()<K){
            que.add(border);
        }
        while(que.size()>0){
            out.println(que.poll());            
        }
    }
    ArrayList<Long> A;
    ArrayList<Long> B;
    ArrayList<Long> C;

    long countMoreThan(long val){
        long res = 0;
        BinarySearch<Long> bs = new BinarySearch<>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                res += C.size() - bs.lowerBound(C, val - A.get(i) - B.get(j));
            }
        }
        return res;
    }
    public class BinarySearch<T extends Comparable<? super T>>{
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