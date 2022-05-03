import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            b[i] = ni();
        }
 
        int[] left = new int[N];
        boolean feasible=true;
        for (int i = 0; i < N; i++) {
            if(i+1-b[i] < 0) feasible = false;
            left[i] = i+1 - b[i];
        }
        int[] right = new int[N];
        for (int i = 0; i < N; i++) {
            int rc = 0;
            for (int j = i+1; j < N; j++) {
                if(b[j] > b[i]) rc++;
                else break;
            }
            right[i] = rc;
        }
        int[] order = new int[N];
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        for (int i = 0; i < N; i++) order[i] = right[i] + left[i];
        int[] op = new int[N];
        int[] used = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(N-1-order[j] == i){
                    if(used[j] == 1) feasible = false;
                    op[i] = b[j];
                    used[j] = 1;
                }
            }
        }
        if(feasible){
            for (int i = 0; i < N; i++) {
                out.println(op[i]);
            }
        }else{
            out.println(-1);
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