import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        String A = ns();
        String B = ns();
        long ans = -99999;
        for (int i = 0; i < 3; i++) {
            int vala = 0;
            if(i==0){
                vala += 900;
            }else{
                vala += Integer.valueOf(A.substring(0,1))*100;
            }
            if(i==1){
                vala += 90;
            }else{
                vala += Integer.valueOf(A.substring(1,2))*10;
            }
            if(i==2){
                vala += 9;
            }else{
                vala += Integer.valueOf(A.substring(2,3))*1;
            }
            ans = Math.max(ans, vala-Integer.valueOf(B));
        }
 
        for (int i = 0; i < 3; i++) {
            int valb = 0;
            if(i==0){
                valb += 100;
            }else{
                valb += Integer.valueOf(B.substring(0,1))*100;
            }
            if(i==1){
                valb += 0;
            }else{
                valb += Integer.valueOf(B.substring(1,2))*10;
            }
            if(i==2){
                valb += 0;
            }else{
                valb += Integer.valueOf(B.substring(2,3))*1;
            }
            ans = Math.max(ans, Integer.valueOf(A)-valb);
        }
        out.println(ans);
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