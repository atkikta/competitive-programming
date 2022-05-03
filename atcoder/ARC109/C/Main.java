import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        n = ni();
        int k = ni();
        hand = ns();
        int[] pow2 = new int[7];
        pow2[0] = 1;
        for (int i = 0; i < pow2.length-1; i++) {
            pow2[i+1] = pow2[i] *2;
        }
        while(k>6){
            String dhand = "";
            dhand += hand;
            dhand += hand;
            char[] nhand = new char[dhand.length()/2];
            for (int i = 0; i < dhand.length()/2; i++) {
                char lh = dhand.charAt(i*2);
                char rh = dhand.charAt(i*2+1);
                if(lh==rh){
                    nhand[i] = lh;
                }else if((lh=='R'&&rh=='S')||(lh=='S'&&rh=='R')){
                    nhand[i] = 'R';
                }else if((lh=='P'&&rh=='R')||(lh=='R'&&rh=='P')){
                    nhand[i] = 'P';
                }else{
                    nhand[i] = 'S';
                }
            }
            hand = String.valueOf(nhand);
            k--;
        }
        if(k<=6){
            char ans = winner(0, pow2[k]);
            out.println(ans);
        }
    }
    int n;
    String hand;
    char winner(int left, int right){
        if(left == right-1){
            return hand.charAt(left%n);
        }else{
            char lh = winner(left, (left+right)/2);
            char rh = winner((left+right)/2, right);
            if(lh==rh){
                return lh;
            }else if((lh=='R'&&rh=='S')||(lh=='S'&&rh=='R')){
                return 'R';
            }else if((lh=='P'&&rh=='R')||(lh=='R'&&rh=='P')){
                return 'P';
            }else{
                return 'S';
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