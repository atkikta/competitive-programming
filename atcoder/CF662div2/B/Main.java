import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int[] count = new int[100001];
        for (int i = 0; i < N; i++) {
            int a = ni();
            count[a]++;
        }
        int q = ni();
        int two = 0;
        int four = 0;
        int six = 0;
        int eight = 0;
        for (int i = 0; i < count.length; i++) {
            if(count[i] >= 2) two ++;
            if(count[i] >= 4) four++;
            if(count[i] >= 6) six++;
            if(count[i] >= 8) eight++;
        }
        for (int i = 0; i < q; i++) {
            String s = ns();
            int x = ni();
            if(s.equals("+")){
                if(count[x] == 1) two++;
                if(count[x] == 3) {
                    four++;
                }
                if(count[x] == 5) {
                    six++;
                }
                if(count[x] == 7){
                    eight++;
                }
                count[x] ++;
            }else{
                if(count[x]==2) two--;
                if(count[x]==4) {
                    four--;
                }
                if(count[x]==6) {
                    six--;
                }
                if(count[x]==8){
                    eight--;
                }
                count[x] --;
            }
            // for (int j = 0; j < 10; j++) {
            //     System.out.print(count[j]);
            // }
            // System.out.println(two);
            // System.out.println(four);
            // System.out.println(six);
            if((two>=3&&four>=1)||(two>=2&&six>=1)||(four>=2)||(eight>=1)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
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