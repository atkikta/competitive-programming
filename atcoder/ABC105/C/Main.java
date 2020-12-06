import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        if(N==0){
            out.println(0);
            return;
        }
        int[] pos = new int[16];
        pos[0] = 2;
        int pow4 = 4;
        for (int i = 1; i < pos.length; i++) {
            pos[i] = pos[i-1] + pow4;
            pow4 *= 4;
        }
        int[] neg = new int[15];
        neg[0] = -3;
        int p8 = -8;
        for (int i = 1; i < neg.length; i++) {
            neg[i] = neg[i-1] + p8;
            p8 *= 4;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(N!=0){
            // System.out.println(N);
            if(N>0){
                for (int i = 0; i < 16; i++) {
                    if(N < pos[i]){
                        N -= pow4(i);
                        ans.add(i*2);
                        break;
                    }
                }
            }else{
                if(N<=neg[14]){
                    // System.out.println(pow4(15));
                    N += pow4(15);
                    N += pow4(15);
                    ans.add(31);
                }else{
                    for (int i = 0; i < 15; i++) {
                        if(neg[i] < N){
                            N += pow4(i)*2;
                            ans.add(i*2+1);
                            break;
                        }
                    }
                }
            }
        }
        Collections.sort(ans,Comparator.reverseOrder());
        // out.println(ans);
        long prev = -1;
        for (Integer i : ans) {
            if(prev>0){
                for (int j = 0; j < prev - i -1; j++) {
                    out.print(0);
                }
            }
            out.print(1);
            prev = i;
        }
        for (int i = 0; i < prev; i++) {
            out.print(0);
        }
        out.println();
    }

    final int mod = 1000000007;
    final BigInteger MOD = BigInteger.valueOf(mod);
    int pow4(int x){
        int ret = 1;
        for (int i = 0; i < x; i++) {
            ret *= 4;
        }
        return ret;
    }
    int pow10(int x){
        int ret = 1;
        for (int i = 0; i < x; i++) {
            ret *= 10;
        }
        return ret;
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