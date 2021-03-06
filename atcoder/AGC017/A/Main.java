import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int P = ni();
        int[] a = new int[N];
        int numOdd = 0;
        int numEven = 0;
        for (int i = 0; i < N; i++) {
            int A = ni();
            a[i] = A;
            if(A%2==0) numEven ++;
            else numOdd++;
        }
        if(numOdd==0){
            if(P%2==1){
                out.println(0);
                return;
            }
        }
        long selectEven = 1;
        for (int i = 0; i < numEven; i++) {
            selectEven *= 2;
        }
        long[] com = new long[numOdd+1];
        com[0] = 1;
        for (int i = 1; i < com.length; i++) {
            com[i] = com[i-1] * (numOdd - i +1) / i;
        }
        // System.out.println(Arrays.toString(com));
        long ans = 0;
        if(P%2 == 1){
            for (int i = 1; i <= numOdd; i+=2) {
                ans += com[i];
            }
        }else{
            for (int i = 0; i <= numOdd; i+=2) {
                ans += com[i];
            }
        }
 
        out.println(ans * selectEven);
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