import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int K = ni();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int t = ni();
            int d = ni();
            list.add(new ArrayList<>(Arrays.asList(t, d)));
        }
        Collections.sort(list, (x,y)->y.get(1).compareTo(x.get(1)));
        int count = 0;
        long ans = 0;
        HashMap<Integer, PriorityQueue<Integer>> type = new HashMap<>();
        PriorityQueue<ArrayList<Integer>> minima = new PriorityQueue<>((x,y)->x.get(1).compareTo(y.get(1)));
        for (int i = 0; i < N; i++) {
            System.out.println(type);
            System.out.println(ans);
            if(count<K){
                System.out.println(count);
                ans += list.get(i).get(1);
                long vari = type.size();
                ans -= vari * vari;
                type.putIfAbsent(list.get(i).get(0), new PriorityQueue<>());
                type.get(list.get(i).get(0)).add(list.get(i).get(1));
                vari = type.size();
                ans += vari * vari;
                minima.add(new ArrayList<>(Arrays.asList(list.get(i).get(0), list.get(i).get(1))));
                count++;
            }else{
                if(!type.containsKey(list.get(i).get(0))){
                    long vari = type.size();
                    ArrayList<Integer> mini = minima.peek();
                    long diff = - vari*vari + list.get(i).get(1) - mini.get(1);
                    if(type.get(mini.get(0)).size()==1) diff+= vari*vari;
                    else diff += (vari+1) * (vari+1);
                    if(diff>0){
                        minima.poll();
                        minima.add(new ArrayList<>(Arrays.asList(list.get(i).get(0), list.get(i).get(1))));
                        if(type.get(mini.get(0)).size()==1){
                            type.remove(mini.get(0));
                        }else{
                            type.get(mini.get(0)).poll();
                        }
                        ans += diff;
                    }
                }
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