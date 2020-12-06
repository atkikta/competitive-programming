import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int[] d10 = new int[10];
        d10[0] = 1;
        for (int i = 1; i < d10.length; i++) {
            d10[i] = d10[i-1] * 10;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(3);
        que.add(5);
        que.add(7);
        while(list.size() <= 26484){
            int n = que.removeFirst();
            boolean use3 = false;
            boolean use5 = false;
            boolean use7 = false;
            int nn = n;
            int d = 0;
            while(nn>0){
                if(nn%10==3) use3=true;
                if(nn%10==5) use5=true;
                if(nn%10==7) use7=true;
                nn = nn/10;
                d++;
            }
            if(use3&&use5&&use7) list.add(n);
            if(d>9) break;
            que.addLast(n+3*d10[d]);
            que.addLast(n+5*d10[d]);
            que.addLast(n+7*d10[d]);
        }
        int ans = 0;
        for (Integer n : list) {
            if(n<=N){
                ans++;
                // System.out.println(n);
            }
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