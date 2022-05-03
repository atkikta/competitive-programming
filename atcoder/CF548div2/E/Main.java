import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int n = ni();
        int m = ni();
        int[] p = new int[n];
        for (int i = 0; i < p.length; i++) {
            p[i] = ni();
        }
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = ni()-1;
        }
        int d = ni();
        HashSet<Integer> leave = new HashSet<>();
        ArrayList<Integer> leaveorder = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            int l = ni()-1;
            leave.add(l);
            leaveorder.add(l);
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        HashMap<Integer, ArrayList<ArrayList<Integer>>> ptoci = new HashMap<>();
        ArrayList<ArrayList<Integer>> dummy = new ArrayList<>();
        dummy.add(new ArrayList<>(Arrays.asList(-1,n)));
        ptoci.put(-1, new ArrayList<>(dummy));
        for (int i = 0; i < n; i++) {
            if(!leave.contains(i)){
                int club = c[i];
                int pote = p[i];
                if(ptoci.containsKey(pote-1)){
                    for (ArrayList<Integer> ci : ptoci.get(pote-1)) {
                        if(club != ci.get(0)){
                            graph.get(ci.get(1)).add(i);
                        }
                    }
                }
                if(ptoci.containsKey(pote+1)){
                    for (ArrayList<Integer> ci : ptoci.get(pote+1)) {
                        graph.get(i).add(ci.get(1));
                    }
                }
                ptoci.putIfAbsent(pote, new ArrayList<>());
                ptoci.get(pote).add(new ArrayList<>(Arrays.asList(club, i)));
            }
        }
        // for (int i = d-1; i>=0; i--) {
        //     int l = leaveorder.get(i);
        // }
        System.out.println(graph);
        long ans = 0;
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