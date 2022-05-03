import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        long[] A = new long[N];
        long[] B = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = nl();
            B[i] = nl();
        }
        int countzero = 0;
        HashMap<Long, HashMap<Long, ArrayList<Integer>>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if(A[i]>0 && B[i]>0){
                long g = gcd(A[i], B[i]);
                long a = A[i]/g;
                long b = B[i]/g;
                map.putIfAbsent(a, new HashMap<>());
                map.get(a).putIfAbsent(b, new ArrayList<>(Arrays.asList(0,0)));
                map.get(a).get(b).set(0, map.get(a).get(b).get(0)+1);
            }else if(A[i]<0 || B[i]<0){
                long a = A[i] < 0 ? -A[i] :A[i];
                long b = B[i] < 0 ? -B[i] :B[i];
                long g = gcd(a, b);
                a = a/g;
                b = b/g;
                map.putIfAbsent(b, new HashMap<>());
                map.get(b).putIfAbsent(a, new ArrayList<>(Arrays.asList(0,0)));
                map.get(b).get(a).set(1, map.get(b).get(a).get(1)+1);
            }else if(A[i]==0 && B[i]!=0){
                map.putIfAbsent(0L, new HashMap<>());
                map.get(0L).putIfAbsent(0L, new ArrayList<>(Arrays.asList(0,0)));
                map.get(0L).get(0L).set(1, map.get(0L).get(0L).get(1)+1);
            }else if(A[i]!=0 && B[i]==0){
                map.putIfAbsent(0L, new HashMap<>());
                map.get(0L).putIfAbsent(0L, new ArrayList<>(Arrays.asList(0,0)));
                map.get(0L).get(0L).set(0, map.get(0L).get(0L).get(0)+1);
            }else if(A[i]==0 && B[i]==0){
                countzero++;
            }
        }
        int ans = 1;
        for (Long a : map.keySet()) {
            for (Long b : map.get(a).keySet()) {
                ArrayList<Integer> li = map.get(a).get(b);
                if(li.get(0)==0&&li.get(1)==0) continue;
                else if(li.get(0)==0) {
                    for (int i = 0; i < li.get(1); i++) {
                        ans = mul(ans, 2);
                    }
                }else if(li.get(1)==0){
                    for (int i = 0; i < li.get(0); i++) {
                        ans = mul(ans,2);
                    }
                }else{
                    int count1 = 1;
                    for (int i = 0; i < li.get(0); i++) {
                        count1 = mul(count1,2);
                    }
                    int count2 = 1;
                    for (int i = 0; i < li.get(1); i++) {
                        count2 = mul(count2, 2);
                    }
                    int count = add(count1, count2);
                    count = count-1;
                    ans = mul(ans,count);
                }
            }
        }
        // System.out.println(map.toString());
        ans = add(ans, countzero);
        ans = sub(ans, 1);
        out.println(ans);
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