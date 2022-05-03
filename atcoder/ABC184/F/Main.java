import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int T = ni();
        int n1 = N/2;
        int n2 = N - n1;
        int[] A1 = new int[n1];
        for (int i = 0; i < n1; i++){
            A1[i] = ni();
        }
        int[] A2 = new int[n2];
        for (int i = 0; i < n2; i++){
            A2[i] = ni();
        }

        ArrayList<Long> l1 = new ArrayList<>();
        for (int i = 1; i < (1<<n1); i++) {
            long val = 0;
            for (int j = 0; j < n1; j++) {
                if(((i>>j)&1)==1){
                    val += A1[j];
                }
            }
            l1.add(val);
        }
        Collections.sort(l1);
        ArrayList<Long> l2 = new ArrayList<>();
        for (int i = 1; i < (1<<n2); i++) {
            long val = 0;
            for (int j = 0; j < n2; j++) {
                if(((i>>j)&1)==1){
                    val += A2[j];
                }
            }
            l2.add(val);
        }
        l2.add(0L);
        Collections.sort(l2);
        // System.out.println(l1);
        // System.out.println(l2);
        long ans = 0;
        BinarySearch<Long> bs = new BinarySearch<>();
        for (Long val2 : l2) {
            if(val2>T) break;
            else{
                int at = bs.upperBound(l1, T-val2);
                // System.out.println(String.format("%d %d", T-val2, at));
                // if(at==l1.size()) ans = Math.max(ans, val2 + l1.get(at-1));
                if(at==0) ans = Math.max(ans, val2);
                else ans = Math.max(ans, val2 + l1.get(at-1));
            }
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
    
    long gcd(long num1,long num2) {
        if(num2 == 0) return num1;
        else return gcd(num2 , num1 % num2 );
    }
    long lcm(long a, long b){
        return (a / gcd(a, b)) * b;
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
    void print2DArray(int[][] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
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