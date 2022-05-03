import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        ArrayList<ArrayDeque<Integer>> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(new ArrayDeque<Integer>());
            for (int j = 0; j < N-1; j++) {
                A.get(i).addLast(ni()-1);
            }
        }
        // System.out.println(A);
        ArrayDeque<Integer> pair = new ArrayDeque<>();
        int[] looked = new int[N];
        for (int i = 0; i < N; i++) {
            if(looked[i]==1) continue;
            looked[i] = 1;
            int opp = A.get(i).peekFirst();
            if(A.get(opp).peekFirst()==i){
                looked[i] = 1;
                looked[opp] = 1;
                pair.addLast(i);
                pair.addLast(opp);
            }
        }
        int numgame = 0;
        long ans = 0;
        while(numgame < N*(N-1)/2){
            if(pair.size()==0){
                out.println(-1);
                return;
            }
            ans++;
            ArrayList<Integer> next = new ArrayList<>();
            int[] played = new int[N];
            // out.println(pair);
            while(pair.size()>0) {
                int s = pair.removeFirst();
                int t = pair.removeFirst();
                // out.println(String.format("%d %d %d",ans, s, t));
                numgame++;
                A.get(s).removeFirst();
                A.get(t).removeFirst();
                if(A.get(s).size()>0){
                    int ns = A.get(s).peekFirst();
                    if(A.get(ns).peekFirst()==s) {
                        next.add(s);
                        next.add(ns);
                    }
                }
                if(A.get(t).size()>0){
                    int nt = A.get(t).peekFirst();
                    if(A.get(nt).peekFirst()==t) {
                        next.add(t);
                        next.add(nt);
                    }
                }
            }
            for (int i = 0; i < next.size(); i++) {
                pair.addLast(next.get(i));
            }
        }

 
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