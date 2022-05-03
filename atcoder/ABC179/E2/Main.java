import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

 
public class Main {
 
    void solve() throws IOException {
        long N = nl();
        long X = nl();
        long M = nl();
        LoopSkip loopskip = new LoopSkip(M);
        long ans = loopskip.run(N, X, M);
        out.println(ans);
    }
    class LoopSkip{
        long[][] pre;
        public LoopSkip(long MaxPeriod){
            this.pre = new long[(int)MaxPeriod][2];
            for (int i = 0; i < MaxPeriod; i++) {
                for (int j = 0; j < 2; j++) {
                    pre[i][j] = -1;
                }
            }
        }
        public long run(long numStep, long initVal, long update){
            long ans = 0;
            long X = initVal;
            long N = numStep;
            for (long i = 0; i < N; i++) {
                // sum up X
                ans += X;
                if(pre[(int)X][0] != -1){
                    long period = i-pre[(int)X][0];
                    long sum = ans - pre[(int)X][1];
                    long res = N-1-i;
                    ans+=res/period*sum;
                    i+=res/period*period;
                }
                pre[(int)X][0] = i;
                pre[(int)X][1] = ans;
                // update X
                X = X*X%update;
            }
            return ans;
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