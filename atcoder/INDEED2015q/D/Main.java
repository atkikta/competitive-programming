import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        long N = nl();
        int C = ni();
        int[] a = new int[(int)N];
        for (int i = 0; i < N; i++) {
            a[i] = ni();
        } 
        HashMap<Integer, Integer> last = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> interval = new HashMap<>();
        for (int i = 1; i <= C; i++) {
            interval.put(i, new ArrayList<>());            
        }
        for (int i = 0; i < N; i++) {
            if(!last.containsKey(a[i])) {
                if(i>0)interval.get(a[i]).add(i);
            }
            else{
                if(i-last.get(a[i])>1) interval.get(a[i]).add(i-last.get(a[i])-1);
            }
            last.put(a[i], i);
        }
        for (int i = 1; i <= C; i++) {
            if(!last.containsKey(i)){
                interval.get(i).add((int)N);
            }else{
                if(a[(int)N-1]!=i) interval.get(i).add((int)N-1 - last.get(i));
            }            
        }
        for (int i = 1; i <= C; i++) {
            long res = N * (N+1) /2;
            for (Integer itb : interval.get(i)) {
                res -= itb * 1L * (itb+1) /2;
            }
            System.out.println(res);
        }
        // System.out.println(last);
        // System.out.println(interval);

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