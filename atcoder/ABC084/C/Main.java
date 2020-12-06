import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int[] C = new int[N];
        int[] S = new int[N];
        int[] F = new int[N];
        for (int i = 0; i < N-1; i++) {
            C[i] = ni();
            S[i] = ni();
            F[i] = ni();
        }
        for (int i = 0; i < N; i++) {
            int time = 0;
            for (int j = i; j < N; j++) {
                // System.out.println(time);
                if(j == N-1) out.println(time);
                else{
                    time = Math.max(time, S[j]);
                    time = time%F[j]==0 ? time : F[j] * (time/F[j] + 1);
                    time = time + C[j];
                }               
            }
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