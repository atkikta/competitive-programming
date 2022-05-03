import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        String s = ns();
        ArrayList<ArrayList<Character>> subs = new ArrayList<>();
        ArrayList<Character> sub = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='f' || s.charAt(i)=='o' || s.charAt(i)=='x'){
                sub.add(s.charAt(i));
            }else{
                if(sub.size()>0) subs.add(sub);
                sub = new ArrayList<>();
            }
        }
        if(sub.size()>0) subs.add(sub);
        long count = 0;
        for (int i = 0; i < subs.size(); i++) {
            ArrayList<Character> str = subs.get(i);
            ArrayDeque<Character> que = new ArrayDeque<>();
            // System.out.println(str);
            for (int j = 0; j < str.size(); j++) {
                // System.out.println(que.toString());
                if(str.get(j)=='f'){
                    que.addFirst('f');
                }
                if(str.get(j)=='o'){
                    que.addFirst('o');
                }
                if(str.get(j)=='x'){
                    if(que.size()<2){
                        que.addFirst('x');
                        continue;
                    }
                    Character last = que.removeFirst();
                    if(last=='o' && que.size()>=1 && que.peekFirst()=='f'){
                        count++;
                        que.removeFirst();
                    }else{
                        que.addFirst('o');
                        que.addFirst('x');
                    }
                }
            }
            // System.out.println(count);
        }
        out.println(N - count*3);

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