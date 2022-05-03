import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        String S = ns();
        int[] cA = new int[N+1];
        int[] cT = new int[N+1];
        int[] cG = new int[N+1];
        int[] cC = new int[N+1];
        for (int i = 0; i < N; i++) {
            cA[i+1] = cA[i];
            cT[i+1] = cT[i];
            cG[i+1] = cG[i];
            cC[i+1] = cC[i];
            if(S.charAt(i)=='A') cA[i+1]++;
            if(S.charAt(i)=='T') cT[i+1]++;
            if(S.charAt(i)=='G') cG[i+1]++;
            if(S.charAt(i)=='C') cC[i+1]++;
        }
        char[] cS = new char[N];
        for (int i = 0; i < N; i++) {
            if(S.charAt(i)=='A')cS[i] = 'T';
            if(S.charAt(i)=='T')cS[i] = 'A';
            if(S.charAt(i)=='G')cS[i] = 'C';
            if(S.charAt(i)=='C')cS[i] = 'G';
        }
        int[] ccA = new int[N+1];
        int[] ccT = new int[N+1];
        int[] ccG = new int[N+1];
        int[] ccC = new int[N+1];
        for (int i = 0; i < N; i++) {
            ccA[i+1] = ccA[i];
            ccT[i+1] = ccT[i];
            ccG[i+1] = ccG[i];
            ccC[i+1] = ccC[i];
            if(cS[i]=='A') ccA[i+1]++;
            if(cS[i]=='T') ccT[i+1]++;
            if(cS[i]=='G') ccG[i+1]++;
            if(cS[i]=='C') ccC[i+1]++;
        }
        // System.out.println(Arrays.toString(cA));
        // System.out.println(Arrays.toString(cT));
        // System.out.println(Arrays.toString(cG));
        // System.out.println(Arrays.toString(cC));
        // System.out.println(Arrays.toString(ccA));
        // System.out.println(Arrays.toString(ccT));
        // System.out.println(Arrays.toString(ccG));
        // System.out.println(Arrays.toString(ccC));
        long ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N+1; j++) {
                if((cA[j]-cA[i] == ccA[j]-ccA[i]) && 
                (cT[j]-cT[i] == ccT[j]-ccT[i]) && 
                (cC[j]-cC[i] == ccC[j]-ccC[i]) &&
                (cG[j]-cG[i] == ccG[j]-ccG[i])){
                    ans++;
                }
            }
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