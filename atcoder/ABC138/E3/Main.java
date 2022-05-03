import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        String s = ns();
        String t = ns();
        String ss = s+s;
        ArrayList<ArrayList<Integer>> loc = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            loc.add(new ArrayList<>());
        }
        for (int i = 0; i < ss.length(); i++) {
            char c = ss.charAt(i);
            loc.get(c-'a').add(i);
        }
        BinarySearch<Integer> bs = new BinarySearch<>();
        long ans = 0;
        int curr = 0;
        for (int i = 0; i < t.length(); i++) {
            char ct = t.charAt(i);
            if(loc.get(ct-'a').size()==0){
                out.println(-1);
                return;
            }
            int nexti = bs.lowerBound(loc.get(ct-'a'), curr);
            int nextl = loc.get(ct-'a').get(nexti)+1;
            ans += nextl - curr;
            curr = nextl;
            curr = curr % s.length();
            // System.out.println(nextl);
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