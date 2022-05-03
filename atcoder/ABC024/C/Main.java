import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int D = ni();
        int K = ni();
        
        int[] L = new int[D];
        int[] R = new int[D];
        for (int i = 0; i < D; i++) {
            L[i] = ni();
            R[i] = ni();
        }
        int[] S = new int[K];
        int[] T = new int[K];
        for (int i = 0; i < K; i++) {
            S[i] = ni();
            T[i] = ni();
        }
        int ans[] = new int[K];
        for (int i = 0; i < D; i++) {
            for (int j = 0; j < K; j++) {
                if(S[j] == T[j]) {
                    continue;
                }else if(S[j] < T[j]){
                    if(L[i] <= S[j] && S[j] <= R[i]){
                        S[j] = Math.min(T[j],R[i]);
                    }
                }else{
                    if(L[i] <= S[j] && S[j] <= R[i]){
                        S[j] = Math.max(T[j],L[i]);
                    }
                }
                ans[j] ++;
            }
        }
        for (int i = 0; i < ans.length; i++) {
            out.println(ans[i]);
        }
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