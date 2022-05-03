import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int Q = ni();
        int[] X = new int[N];
        int[] R = new int[N];
        int[] H = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = ni();
            R[i] = ni();
            H[i] = ni();
        }
        double[] vol = new double[20001];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < H[i]; j++) {
                double r1 = R[i] * (double)(H[i]-j) / (double)H[i];
                double r2 = R[i] * (double)(H[i]-j-1) /(double)H[i];
                double h1 = H[i] - j;
                double h2 = H[i] - j - 1;
                if(X[i] + j  + 1< 20001) vol[X[i]+j+1] += Math.PI/3.0 * (r1*r1*h1 - r2*r2*h2);
            }
        }

        for (int i = 1; i < vol.length; i++) {
            vol[i] = vol[i] + vol[i-1];
        }
        // System.out.println(Arrays.toString(vol));
        for (int i = 0; i < Q; i++) {
            int A = ni();
            int B = ni();
            out.println(String.format("%f",vol[B] - vol[A]));
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

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.PrintWriter;
// import java.math.BigDecimal;
// import java.math.BigInteger;
// import java.math.RoundingMode;
// import java.util.*;
 
// public class Main {
 
//     void solve() throws IOException {
//         int N = ni();
//         int Q = ni();
//         int[] X = new int[N];
//         int[] R = new int[N];
//         int[] H = new int[N];
//         for (int i = 0; i < N; i++) {
//             X[i] = ni();
//             R[i] = ni();
//             H[i] = ni();
//         }
//         BigDecimal[] vol = new BigDecimal[20001];
//         for (int i = 0; i < vol.length; i++) {
//             vol[i] = BigDecimal.ZERO;
//         }
//         for (int i = 0; i < N; i++) {
//             for (int j = 0; j < H[i]-1; j++) {
//                 BigDecimal r1 = BigDecimal.valueOf(R[i]).multiply(BigDecimal.valueOf((H[i]-j+1))).divide(BigDecimal.valueOf(H[i]), 6,RoundingMode.HALF_UP);
//                 BigDecimal r2 = BigDecimal.valueOf(R[i]).multiply(BigDecimal.valueOf((H[i]-j))).divide(BigDecimal.valueOf(H[i]), 6 ,RoundingMode.HALF_UP);
//                 BigDecimal h1 = BigDecimal.valueOf(H[i]- j+1);
//                 BigDecimal h2 = BigDecimal.valueOf(H[i]- j);
//                 BigDecimal co = r1.multiply(r1).multiply(h1).add(r2.multiply(r2).multiply(h2).negate());
//                 if(X[i] + j  + 1< 20001) vol[X[i]+j+1] = vol[X[i]+j+1].add(pi.divide(BigDecimal.valueOf(3),6,RoundingMode.HALF_UP).multiply(co));
//             }
//         }
//         BigDecimal[] csum = new BigDecimal[200001];
//         csum[0] = BigDecimal.ZERO;
//         for (int i = 1; i < vol.length; i++) {
//             csum[i] = csum[i-1].add(vol[i]);
//         }
//         // System.out.println(Arrays.toString(vol));
//         for (int i = 0; i < Q; i++) {
//             int A = ni();
//             int B = ni();
//             out.println(String.format("%f",csum[B].add(csum[A].negate()).doubleValue()));
//         }
//     }
//     final BigDecimal pi = BigDecimal.valueOf(Math.PI);
//     final int mod = 1000000007;
//     final BigInteger MOD = BigInteger.valueOf(mod);
    
//     long gcd(long num1,long num2) {
//         if(num2 == 0) return num1;
//         else return gcd(num2 , num1 % num2 );
//     }
//     long lcm(long a, long b){
//         return (a / gcd(a, b)) * b;
//     }
//     int mul(int x, int y){
//         int val = (int)((x * 1L * y) % mod);
//         return val>=0 ? val : val+mod;
//     }
//     int add(int x, int y) {
//         x += y;
//         if(x < 0) x += mod;
//         if(x>=mod) x -= mod;
//         return x;
//     }
//     int sub(int x, int y){
//         x = add(x,mod-y);
//         if(x < 0) x += mod;
//         if(x>=mod) x -= mod;
//         return x;
//     }
//     String ns() throws IOException {
//         while (!tok.hasMoreTokens()) {
//             tok = new StringTokenizer(in.readLine(), " ");
//         }
//         return tok.nextToken();
//     }
 
//     int ni() throws IOException {
//         return Integer.parseInt(ns());
//     }
 
//     long nl() throws IOException {
//         return Long.parseLong(ns());
//     }
 
//     double nd() throws IOException {
//         return Double.parseDouble(ns());
//     }
 
//     String[] nsa(int n) throws IOException {
//         String[] res = new String[n];
//         for (int i = 0; i < n; i++) {
//             res[i] = ns();
//         }
//         return res;
//     }
 
//     int[] nia(int n) throws IOException {
//         int[] res = new int[n];
//         for (int i = 0; i < n; i++) {
//             res[i] = ni();
//         }
//         return res;
//     }
 
//     long[] nla(int n) throws IOException {
//         long[] res = new long[n];
//         for (int i = 0; i < n; i++) {
//             res[i] = nl();
//         }
//         return res;
//     }
//     void print2DArray(int[][] a){
//         for (int i = 0; i < a.length; i++) {
//             System.out.println(Arrays.toString(a[i]));
//         }
//     }
 
//     static BufferedReader in;
//     static PrintWriter out;
//     static StringTokenizer tok;
 
//     public static void main(String[] args) throws IOException {
//         in = new BufferedReader(new InputStreamReader(System.in));
//         out = new PrintWriter(System.out);
//         tok = new StringTokenizer("");
//         Main main = new Main();
//         main.solve();
//         out.close();
//     }
// }