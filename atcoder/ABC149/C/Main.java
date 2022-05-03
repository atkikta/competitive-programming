import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        Sieve sieve = new Sieve(N*2);
        for (int i = N; i < N*2; i++) {
            if(sieve.isPrime(i)) {
                out.println(i);
                return;
            }
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
    final int mod = 1000000007;
    final BigInteger MOD = BigInteger.valueOf(mod);
    int upperBound(ArrayList<Long> list, Long target){
        int i = Collections.binarySearch(list, target, new UpperBoundComparator<Long>());
        return ~i;
    }
    class UpperBoundComparator<T extends Comparable<? super T>> implements Comparator<T>{
        public int compare(T x, T y){
            return (x.compareTo(y) > 0) ? 1 : -1;
        }
    }
    int lowerBound(ArrayList<Long> list, Long target){
        int i = Collections.binarySearch(list, target, new LowerBoundComparator<Long>());
        return ~i;
    }
    class LowerBoundComparator<T extends Comparable<? super T>> implements Comparator<T>{
        public int compare(T x, T y){
            return (x.compareTo(y) >= 0) ? 1 : -1;
        }
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