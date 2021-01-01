import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        String s = ns();
        int x = ni();
        int y = ni();
        ArrayList<Integer> hl = new ArrayList<>();
        ArrayList<Integer> vr = new ArrayList<>();
        int count = 0;
        boolean headHolizontal = true;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='T'){
                if(count>0){
                    if(headHolizontal) {
                        hl.add(count);
                    }
                    else{
                        vr.add(count);
                    }
                }
                count = 0;
                headHolizontal = (!headHolizontal);
            }else{
                count++;
            }
        }

        if(s.charAt(s.length()-1)=='F'){
            if(headHolizontal) {
                hl.add(count);
            }else{
                vr.add(count);
            }
        }
        // System.out.println(hl);
        // System.out.println(vr);
        int size = 16011;
        boolean[][] dpx = new boolean[hl.size()+1][size];
        for (int i = 0; i < hl.size()+1; i++) {
            Arrays.fill(dpx[i],false);
        }
        dpx[0][size/2] = true;
        for (int i = 0; i < hl.size(); i++) {
            for (int j = 0; j < size; j++) {
                if((s.charAt(0)=='T' || i>0) && dpx[i][j]) dpx[i+1][j-hl.get(i)] = true;
                if(dpx[i][j]) dpx[i+1][j+hl.get(i)] = true;
            }
        }
        boolean[][] dpy = new boolean[vr.size()+1][size];
        for (int i = 0; i < vr.size()+1; i++) {
            Arrays.fill(dpy[i],false);
        }
        dpy[0][size/2] = true;
        for (int i = 0; i < vr.size(); i++) {
            for (int j = 0; j < size; j++) {
                if(dpy[i][j]) dpy[i+1][j-vr.get(i)] = true;
                if(dpy[i][j]) dpy[i+1][j+vr.get(i)] = true;
            }
        }
        // System.out.println(Arrays.toString(dpx[hl.size()]));
        // System.out.println(Arrays.toString(dpy[vr.size()]));
        if(dpx[hl.size()][size/2+x] && dpy[vr.size()][size/2+y]) out.println("Yes");
        else out.println("No");
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