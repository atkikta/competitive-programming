import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import org.graalvm.compiler.lir.aarch64.AArch64AtomicMove.CompareAndSwapOp;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int K = ni();
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> mins = new ArrayList<>();
        ArrayList<Integer> puls = new ArrayList<>();
        int nummin = 0;
        for (int i = 0; i < A.length; i++) {
            int a = ni();
            A.add(a);
            if(a<0) nummin++;
            if(a>=0) puls.add(a);
            if(a<0) mins.add(a);
        }
        if(nummin == N && K%2==1){
            int ans=1;
            Collections.sort(A,Comparator.reverseOrder());
            for (int i = 0; i < K; i++) {
                ans = mul(ans, A.get(i));
                out.println(ans);
                return;
            }
        }
        int ans = 1;
        int count = 0;
        int countm = 0;
        Collections.sort(A, (x,y)->((Integer)(Math.abs(y))).compareTo(Math.abs(x)));
        while(count < K) {
            if(ans > 0)
        }
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