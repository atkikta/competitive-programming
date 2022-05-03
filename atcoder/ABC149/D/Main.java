import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int K = ni();
        int R = ni();
        int S = ni();
        int P = ni();
        String T = ns();
        long ans = 0;
        for (int i = 0; i < K; i++) {
            int time = i;
            int[] dp = new int[3];
            while(time < N){
                if(T.charAt(time) == 'r'){
                    int r = Math.max(dp[1],dp[2]);
                    int s = Math.max(dp[0],dp[2]);
                    int p = Math.max(dp[0] + P, dp[1]+ P);
                    dp[0] = r;
                    dp[1] = s;
                    dp[2] = p;
                }
                if(T.charAt(time) == 's'){
                    int r = Math.max(dp[1]+R,dp[2]+R);
                    int s = Math.max(dp[0], dp[2]);
                    int p = Math.max(dp[0], dp[1]);
                    dp[0] = r;
                    dp[1] = s;
                    dp[2] = p;
                }
                if(T.charAt(time) == 'p'){
                    int r = Math.max(dp[1],dp[2]);
                    int s = Math.max(dp[0]+S,dp[2]+S);
                    int p = Math.max(dp[0],dp[1]);
                    dp[0] = r;
                    dp[1] = s;
                    dp[2] = p;
                }    
                // System.out.println(time + " " +dp[0] + " "+ dp[1] + " " + dp[2]);
                time += K;
            }
            ans += Math.max(Math.max(dp[0],dp[1]),dp[2]);
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