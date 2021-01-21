import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        long N = nl();
        int X = ni();
        int M = ni();
        int[] next = new int[M];
        for (int i = 0; i < M; i++) {
            next[i] = (int)((i * 1L * 1) % M);
        }
        int before_loop = 0;
        int loop_size = 0;
        int[] visited = new int[M];
        Arrays.fill(visited,-1);
        visited[X] = 0;
        long[] sum = new long[M];
        sum[0] = X;
        long loopsum = 0;
        long ans = X;
        int now = 0;
        for (int i = 1; i < M+1; i++) {
            X = (int)((X * 1L * X)%M);
            sum[i] = sum[i-1] + X;
            if(visited[X]!=-1){
                before_loop = visited[X];
                loop_size = i - before_loop;
                loopsum = sum[i] - sum[before_loop];
                now = i;
                break;
            }
            ans += X;
            visited[X] = i;
        }
        System.out.println(String.format("%d %d %d %d", before_loop, loop_size, loopsum, X));
        System.out.println(ans);
        System.out.println(now);
        ans += X;
        ans += loopsum * ((N-now-loop_size-1)/loop_size);
        for (int i = 0; i < (N-before_loop)%loop_size; i++) {
            ans += (int)((X * 1L * X)%M);
        }
        out.println(ans);
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