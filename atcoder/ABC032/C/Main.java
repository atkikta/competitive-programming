import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int K = ni();
        int[] s = new int[N];
        int mins = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            s[i] = ni();
            mins = Math.min(mins, s[i]);
        }
        if(mins==0){
            out.println(N);
            return;
        }
        int left = 0;
        int right = 0;
        long prod = 1;
        int maxlen = 0;
        while(right<N){
            if(prod>K && left<right){
                left++;
                prod = prod/s[left-1];
            }else if(prod>K && left==right){
                left++;
                right++;
                prod = prod*s[right-1]/s[left-1];
            }else{
                right++;
                prod = prod*s[right-1];
                if(prod <= K) maxlen = Math.max(maxlen, right-left);
            }
        }
        int ans = maxlen;
        out.println(ans);
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