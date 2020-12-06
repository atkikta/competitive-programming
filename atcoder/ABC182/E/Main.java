import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int H = ni();
        int W = ni();
        int N = ni();
        int M = ni();
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = ni()-1;
            b[i] = ni()-1;
        }
        int[] c = new int[M];
        int[] d = new int[M];
        ArrayList<ArrayList<Integer>> hbloc = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            hbloc.add(new ArrayList<>());
        }
        ArrayList<ArrayList<Integer>> vbloc = new ArrayList<>();
            for (int i = 0; i < W; i++) {
                vbloc.add(new ArrayList<>());
            }
        for (int i = 0; i < M; i++) {
            int C = ni()-1;
            int D = ni()-1;
            hbloc.get(C).add(D);
            vbloc.get(D).add(C);
        }
        for (int i = 0; i < H; i++) {
            Collections.sort(hbloc.get(i));
        }
        for (int i = 0; i < W; i++) {
            Collections.sort(vbloc.get(i));
        }
        BinarySearch<Integer> bs = new BinarySearch<>();
        int[][] hg = new int[H][W+1];
        for (int i = 0; i < N; i++) {
            int idx = bs.lowerBound(hbloc.get(a[i]), b[i]);
            int leftend;
            if(idx==0) leftend = 0;
            else leftend = hbloc.get(a[i]).get(idx-1)+1;
            int rightend;
            if(idx==hbloc.get(a[i]).size()) rightend = W-1;
            else rightend = hbloc.get(a[i]).get(idx)-1;
            hg[a[i]][leftend]++;
            hg[a[i]][rightend+1]--;
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                hg[i][j+1] += hg[i][j];
            }
        }
        // print2DArray(hg);
        int[][] vg = new int[H+1][W];
        for (int i = 0; i < N; i++) {
            int idx = bs.lowerBound(vbloc.get(b[i]), a[i]);
            int upend;
            if(idx==0) upend = 0;
            else upend = vbloc.get(b[i]).get(idx-1)+1;
            int lowend;
            if(idx==vbloc.get(b[i]).size()) lowend = H-1;
            else lowend = vbloc.get(b[i]).get(idx)-1;
            vg[upend][b[i]]++;
            vg[lowend+1][b[i]]--;
        }
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                vg[j+1][i] += vg[j][i];
            }
        }
        // print2DArray(vg);
        long ans = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(hg[i][j]>=1 ||vg[i][j]>=1) ans ++;
            }
        }
        out.println(ans);
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