import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        String S = ns();
        if(S.length()<=2){
            boolean ans = false;
            if(S.equals("8")) ans = true;
            if(S.equals("16")) ans = true;
            if(S.equals("24")) ans = true;
            if(S.equals("32")) ans = true;
            if(S.equals("48")) ans = true;
            if(S.equals("56")) ans = true;
            if(S.equals("64")) ans = true;
            if(S.equals("72")) ans = true;
            if(S.equals("88")) ans = true;
            if(S.equals("96")) ans = true;
            if(S.equals("61")) ans = true;
            if(S.equals("42")) ans = true;
            if(S.equals("23")) ans = true;
            if(S.equals("84")) ans = true;
            if(S.equals("65")) ans = true;
            if(S.equals("27")) ans = true;
            if(S.equals("69")) ans = true;
            if(ans){
                out.println("Yes");
                return;
            }
        }
        int[] count = new int[10];
        for (int i = 0; i < S.length(); i++) {
            count[Integer.valueOf(S.substring(i, i+1))] ++;
        }
        for (int i = 100; i <=999; i++) {
            if(i%8==0){
                int[] valcount = dig(i);
                if(valcount[0]>0) continue;
                boolean more = true;
                for (int j = 1; j <= 9; j++) {
                    if(valcount[j]>count[j]) more = false;
                }
                if(more){
                    out.println("Yes");
                    return;
                }
            }
        }
        out.println("No");
    }
    boolean ans;
    int[] dig(int i){
        int[] res = new int[10];
        while(i>0){
            res[i%10]++;
            i = i/10;
        }
        return res;
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