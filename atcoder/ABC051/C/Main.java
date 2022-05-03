import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int sx = ni();
        int sy = ni();
        int tx = ni();
        int ty = ni();

        String ans = "";
        int cx = sx;
        int cy = sy;
        while(cx != tx){
            ans += "R";
            cx +=1;
        }
        while(cy!=ty){
            ans += "U";
            cy += 1;
        }
        while(cx!=sx){
            ans += "L";
            cx -=1;
        }
        while(cy!=sy){
            ans += "D";
            cy -=1;
        }
        ans += "L";
        cx--;
        while(cy!=ty+1){
            ans += "U";
            cy ++;
        }
        while(cx!=tx){
            ans += "R";
            cx++;
        }
        ans += "D";
        cy--;
        ans += "R";
        cx++;
        while(cy!=sy-1){
            ans += "D";
            cy--;
        }
        while(cx!=sx){
            ans += "L";
            cx--;
        }
        ans += "U";
        cy++;

 
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