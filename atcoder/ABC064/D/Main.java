import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        String S = ns();
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int numL = 0;
        int numR = 0;
        int maxGap = 0;
        for (int i = 0; i < N; i++) {
            if(S.charAt(i) == '('){
                que.addLast(0);
                numL++;
            }else{
                que.addLast(1);
                numR++;
            }
            maxGap = Math.max(maxGap, numR-numL);
        }
        int gapLast = numL-numR+maxGap;
        // System.out.println(maxGap);
        // System.out.println(gapLast);
        for (int i = 0; i < maxGap; i++) {
            que.addFirst(0);
        }
        for (int i = 0; i < gapLast; i++) {
            que.addLast(1);
        }
        // System.out.println(que.toString());
        int ql = que.size();
        for (int i = 0; i < ql; i++) {
            int a = que.removeFirst();
            if(a == 0){
                out.print("(");
            }else{
                out.print(")");
            }
        }
        out.println("");
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