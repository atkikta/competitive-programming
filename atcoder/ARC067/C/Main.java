import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        // int[] pow2 = new int[10000000];
        // pow2[0] = 1;
        // for (int i = 1; i < pow2.length; i++) {
        //     pow2[i] = mul(pow2[i-1],2);
        // }
        Sieve sieve = new Sieve(N);
        HashMap<Integer,Integer> count = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            HashMap<Integer,Integer> fc = sieve.factorCount(i);
            for (Integer f : fc.keySet()) {
                count.putIfAbsent(f, 0);
                count.put(f, count.get(f)+fc.get(f));
            }
        }
        // System.out.println(count);
        int ans = 1;
        for (Integer key : count.keySet() ){
            if(key==1) continue;
            ans = mul(ans,count.get(key)+1);
        }
        out.println(ans);
    }

    final int mod = 1000000007;
    int mul(int x, int y){
        return (int)((x * 1L * y) % mod);
    }
    int add(int x, int y) {
        x += y;
        return x >= mod ? (x - mod) : x;
    }
    int sub(int x, int y){
        x = add(x,mod-y);
        return x >= mod ? (x - mod) : x;
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

class Sieve {
    private int n;
    private int[] f;
    public ArrayList<Integer> primes = new ArrayList<>();
    public Sieve(int N){
        this.n = N;
        this.f = new int[n+1];
        this.f[0] = -1; // 0 is not prime
        this.f[1] = -1; // 1 is not prime
        for (int i = 2; i <= N; i++) {
            if(f[i]!=0) continue;
            primes.add(i);
            f[i] = i;
            for (int j = i+i; j <=n; j+=i) {
                if(f[j] == 0) f[j] = i;
            }
        }
    }
    public boolean isPrime(int i){
        return f[i] == i;
    }
    public ArrayList<Integer> factorList(int i){
        ArrayList<Integer> res = new ArrayList<>();
        while(i!=1){
            res.add(f[i]);
            i/=f[i];
        }
        return res;
    }
    public HashMap<Integer,Integer> factorCount(int i){
        HashMap<Integer,Integer> res = new HashMap<>();
        while(i!=1){
            res.putIfAbsent(f[i],0);
            res.put(f[i],res.get(f[i])+1);
            i /= f[i];
        }
        return res;
    }
}