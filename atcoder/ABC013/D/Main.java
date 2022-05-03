import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int M = ni();
        int D = ni();
        int[] A = new int[M];
        for (int i = 0; i < M; i++) {
            A[i] = ni()-1;
        }
        int[] at = new int[N];
        for (int i = 0; i < at.length; i++) {
            at[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int temp = at[A[i]];
            at[A[i]] = at[A[i]+1];
            at[A[i]+1] = temp;
        }
        System.err.println(Arrays.toString(at));
        Doubling db = new Doubling(N, D, at);
        int[] after = new int[N];
        for (int j = 0; j < N; j++) {
            after[j] = db.get_after(j, D);     
        }
        System.err.println(Arrays.toString(after));
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[after[i]] = i;
        }
        System.err.println(Arrays.toString(ans));
        for (int i = 0; i < N; i++) {
            out.println(ans[i]+1);
        }
    }
    class Doubling {
        int[][] next;
        int size;
        int LOG_D;

        Doubling(int size, int max_step, int[] after_first){
            this.size = size;
            this.LOG_D = 0;
            int d2 = 1;
            while(d2<max_step){
                d2*=2;
                this.LOG_D++;
            }
            this.next = new int[LOG_D+1][size];
            for (int i = 0; i < size; i++) {
                this.next[0][i] = after_first[i];
            }
            init();
        }
        void init(){
            for (int k = 0; k < LOG_D; k++) {
                for (int i = 0; i < size; i++) {
                    if(next[k][i]==-1){
                        next[k+1][i] = -1;
                    }else{
                        next[k+1][i] = next[k][next[k][i]];
                    }
                }
            }
        }
        int get_after(int pos, int step){
            assert pos<size;
            int p = pos;
            for (int i = LOG_D; i >=0; i--) {
                if(p==-1){
                    break;
                }else{
                    if(((step>>i)&1) == 1){
                        p = next[i][p];
                    }
                }
            }
            return p;
        }    
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