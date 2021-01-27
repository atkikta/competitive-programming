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
        int[][] point = new int[N][2];
        for (int i = 0; i < N; i++) {
            X[i] = ni();
            Y[i] = ni();
            point[i][0] = X[i];
            point[i][1] = Y[i];
        }
        ArrayList<Mat2x2> mat = new ArrayList<>();
        mat.add(new Mat2x2(1, 0, 0, 1));
        ArrayList<Vec2d> vec = new ArrayList<>();
        vec.add(new Vec2d(0, 0));
        int M = ni();
        for (int i = 0; i < M; i++) {
            int t = ni();
            Mat2x2 m = mat.get(i);
            Vec2d  v = vec.get(i);
            if(t==1){
                mat.add(new Mat2x2(0, 1, -1, 0).mul(m));
                vec.add(new Mat2x2(0, 1, -1, 0).mul(v));
            }else if(t==2){
                mat.add(new Mat2x2(0, -1, 1, 0).mul(m));
                vec.add(new Mat2x2(0, -1, 1, 0).mul(v));
            }else if(t==3){
                long p = nl();
                mat.add(new Mat2x2(-1, 0, 0, 1).mul(m));
                vec.add(new Mat2x2(-1, 0, 0, 1).mul(v).add(new Vec2d(2*p, 0)));
            }else if(t==4){
                long p = nl();
                mat.add(new Mat2x2(1, 0, 0, -1).mul(m));
                vec.add(new Mat2x2(1, 0, 0, -1).mul(v).add(new Vec2d(0, 2*p)));
            }
        }
        int Q = ni();
        for (int i = 0; i < Q; i++) {
            int A = ni();
            int B = ni()-1;
            Vec2d p = new Vec2d(point[B][0], point[B][1]);
            // print2DArray(mat.get(A).a);
            // System.out.println(Arrays.toString(vec.get(A).a));
            Vec2d ans = vec.get(A).add(mat.get(A).mul(p));
            out.print(ans.a[0]);
            out.print(" ");
            out.println(ans.a[1]);
        }
    }
    class Mat2x2{
        long[][] a;
        Mat2x2(long a00, long a01, long a10, long a11){
            a = new long[2][2];
            a[0][0] = a00;
            a[0][1] = a01;
            a[1][0] = a10;
            a[1][1] = a11;
        }
        Mat2x2 mul(Mat2x2 b){
            long a00 = a[0][0]*b.a[0][0] + a[0][1]*b.a[1][0]; 
            long a01 = a[0][0]*b.a[0][1] + a[0][1]*b.a[1][1]; 
            long a10 = a[1][0]*b.a[0][0] + a[1][1]*b.a[1][0]; 
            long a11 = a[1][0]*b.a[0][1] + a[1][1]*b.a[1][1];
            return new Mat2x2(a00, a01, a10, a11);
        }
        Vec2d mul(Vec2d b){
            long a0 = a[0][0] * b.a[0] + a[0][1] * b.a[1];
            long a1 = a[1][0] * b.a[0] + a[1][1] * b.a[1];
            return new Vec2d(a0, a1);
        }
    }
    class Vec2d{
        long[] a;
        Vec2d(long a0, long a1){
            a = new long[2];
            a[0] = a0;
            a[1] = a1;
        }
        Vec2d add(Vec2d b){
            return new Vec2d(a[0] + b.a[0], a[1] + b.a[1]);
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
    void print2DArray(long[][] a){
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