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
        int A = ni();
        int B = ni();
        int C = ni();
        ArrayList<Integer> red = new ArrayList<>();
        ArrayList<Integer> gre = new ArrayList<>();
        ArrayList<Integer> whi = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            red.add(ni());
        }
        for (int i = 0; i < B; i++) {
            gre.add(ni());
        }
        for (int i = 0; i < C; i++) {
            whi.add(ni());
        }
        Collections.sort(red, Comparator.reverseOrder());
        Collections.sort(gre, Comparator.reverseOrder());
        Collections.sort(whi, Comparator.reverseOrder());
        ArrayList<Integer> all = new ArrayList<>();
        for (int i = 0; i < X; i++) {
            all.add(red.get(i));
        }
        for (int i = 0; i < Y; i++) {
            all.add(gre.get(i));
        }
        for (int i = 0; i < Math.min(C, X+Y); i++) {
            all.add(whi.get(i));
        }
        Collections.sort(all, Comparator.reverseOrder());
 
        long ans = 0;
        for (int i = 0; i < X+Y; i++) {
            ans += all.get(i);
        }
        out.println(ans);
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