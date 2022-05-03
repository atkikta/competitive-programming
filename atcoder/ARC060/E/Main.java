import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 0; i < N; i++){
            x.add(ni());
        }
        int L = ni();
        int Q = ni();
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 0; i < Q; i++){
            a[i] = ni()-1;
            b[i] = ni()-1;
        }
        int[] pow2 = new int[30];
        pow2[0] = 1;
        for (int i = 1; i < 30; i++) {
            pow2[i] = pow2[i-1] * 2;
        }
        int[][] doubling = new int[30][N];
        int[][] dleft = new int[30][N];
        BinarySearch<Integer> bs = new BinarySearch<>();
        for (int i = 0; i < N; i++) {
            int to = bs.upperBound(x, x.get(i)+L) - 1;
            doubling[0][i] = to;
            int toleft = bs.lowerBound(x, x.get(i)-L);
            dleft[0][i] = toleft;
        }
        for (int i = 1; i < 30; i++) {
            for (int j = 0; j < N; j++) {
                doubling[i][j] = doubling[i-1][doubling[i-1][j]];
                dleft[i][j] = dleft[i-1][dleft[i-1][j]];
            }
        }
        // print2DArray(doubling);
        // print2DArray(dleft);

        for (int i = 0; i < Q; i++) {
            if(a[i]==b[i]){
                out.println(0);
            }else{
                int left = 0;
                int right = N;
                if(b[i]<a[i]){
                    int temp = b[i];
                    b[i] = a[i];
                    a[i] = temp;
                }
                while(left<right-1){
                    int mid = (left+right)/2;
                    int cc = a[i];
                    int cr = 0;
                    for (int j = 0; Math.pow(2,j)<mid; j++) {
                        if((mid>>j & 1)==1){
                            
                        }
                    }
                }
                int count = 0;
                do{
                    int cr = 0;
                    while(doubling[cr][cc]<b[i]){
                        cr++;
                    }
                    count += pow2[cr];
                    cc = doubling[cr][cc];
                }while(doubling[0][cc]<b[i]);
                out.println(count);
            }
        }
    }
    class BinarySearch<T extends Comparable<? super T>>{
        int upperBound(ArrayList<T> list, T target){
            int i = Collections.binarySearch(list, target, (x,y)->(x.compareTo(y) > 0) ? 1 : -1);
            return ~i;
        }
        int lowerBound(ArrayList<T> list, T target){
            int i = Collections.binarySearch(list, target, (x,y)->(x.compareTo(y) >= 0) ? 1 : -1);
            return ~i;
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