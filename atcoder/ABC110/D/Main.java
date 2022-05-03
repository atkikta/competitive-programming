import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        BigInteger md = BigInteger.valueOf(1000000007);
        int N = ni();
        int M = ni();
        HashMap<Integer,Integer> fc = new HashMap<>();
        int f = 2;
        int m = M;
        while(f * f <=M){
            if(m%f!=0) f++;
            else{
                fc.putIfAbsent(f, 0);
                fc.put(f,fc.get(f)+1);
                m /= f;
            }
        }
        if(m>1){
            fc.putIfAbsent(m, 0);
            fc.put(m,fc.get(m)+1);
        }
        BigInteger ans = BigInteger.ONE;
        // System.out.println(fc.toString());
        for (Integer fac : fc.keySet()) {
            int nfac = fc.get(fac);
            // System.out.println(nfac);
            // System.out.println(combinationWithReplication(nfac, N));
            ans = ans.multiply(combinationWithReplication(nfac, N));
            ans = ans.mod(md);
        }
 
        out.println(ans);
    }

    BigInteger combinationWithReplication(int n, int k){
        BigInteger res = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            res = res.multiply(BigInteger.valueOf(n+k-1-i));
        }
        for (int i = 0; i < n; i++) {
            res = res.divide(BigInteger.valueOf(n-i));
        }
        return res;
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