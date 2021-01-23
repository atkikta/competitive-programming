import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int[] X = new int[N];
        int[] Y = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = ni();
            Y[i] = ni();
        }
        int M = ni();
        int[] sw = new int[M+1];
        int[] mulx = new int[M+1];
        int[] muly = new int[M+1];
        for (int i = 0; i < muly.length; i++) {
            mulx[i] = 1;
            muly[i] = 1;
        }
        long[] addx = new long[M+1];
        long[] addy = new long[M+1];
        for (int i = 0; i < M; i++) {
            int t = ni();
            if(t==1){
                sw[i+1] = sw[i]+1;
                if(sw[i+1]%2==1){
                    mulx[i+1] = mulx[i] * -1;
                    addx[i+1] = addx[i] * -1;
                    muly[i+1] = muly[i];
                    addy[i+1] = addy[i];
                }else{
                    mulx[i+1] = mulx[i];
                    addx[i+1] = addx[i];
                    muly[i+1] = muly[i] * -1;
                    addy[i+1] = addy[i] * -1;
                }
            }
            if(t==2){
                sw[i+1] = sw[i]+1;
                if(sw[i+1]%2==0){
                    mulx[i+1] = mulx[i] * -1;
                    addx[i+1] = addx[i] * -1;
                    muly[i+1] = muly[i];
                    addy[i+1] = addy[i];
                }else{
                    mulx[i+1] = mulx[i];
                    addx[i+1] = addx[i];
                    muly[i+1] = muly[i] * -1;
                    addy[i+1] = addy[i] * -1;
                }
            }
            if(t==3){
                long p = nl();
                sw[i+1] = sw[i];
                if(sw[i+i]==0){
                    mulx[i+1] = mulx[i] * -1;
                    addx[i+1] = addx[i] * -1 + 2*p;
                    addy[i+1] = addy[i];
                    muly[i+1] = muly[i];
                }else{
                    muly[i+1] = muly[i] * -1;
                    addy[i+1] = addy[i] * -1 + 2*p;
                    addx[i+1] = addx[i];
                    mulx[i+1] = mulx[i];
                }
            }
            if(t==4){
                long p = nl();
                sw[i+1] = sw[i];
                if(sw[i+1]==1){
                    mulx[i+1] = mulx[i] * -1;
                    addx[i+1] = addx[i] * -1 + 2*p;
                    addy[i+1] = addy[i];
                    muly[i+1] = muly[i];
                }else{
                    muly[i+1] = muly[i] * -1;
                    addy[i+1] = addy[i] * -1 + 2*p;
                    addx[i+1] = addx[i];
                    mulx[i+1] = mulx[i];
                }
            }
            System.out.println(Arrays.toString(mulx));
            System.out.println(Arrays.toString(addx));
            System.out.println(Arrays.toString(muly));
            System.out.println(Arrays.toString(addy));
        }
        int Q = ni();
        for (int i = 0; i < Q; i++) {
            int A = ni();
            int B = ni()-1;
            if(sw[A] == 0){
                long x = X[B];
                long y = Y[B];
                x = x * mulx[A] + addx[A];
                y = y * muly[A] + addy[A];
                out.print(x);
                out.print(" ");
                out.println(y);
            }else{
                long x = X[B];
                long y = Y[B];
                x = x * mulx[A] + addx[A];
                y = y * muly[A] + addy[A];
                out.print(y);
                out.print(" ");
                out.println(x);

            }
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