import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        R = ni();
        C = ni();
        D = ni();
        a = new int[R][C];
        long ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                a[i][j] = ni();
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(i+j<=D && (i+j)%2==D%2) ans = Math.max(ans, a[i][j]);
            }
        }

        out.println(ans);
    }
    void dfs(int i, int j, int count){
        // System.out.println(i+" "+j+" "+count);
        if(count%2 == D%2){
            maxVal = Math.max(maxVal,a[i][j]);
        }
        a[i][j] = -1;
        if(i<R-1 && count <D && a[i+1][j]>0) dfs(i+1,j,count+1);
        if(0<i && count <D && a[i-1][j]>0) dfs(i-1,j,count+1);
        if(j<C-1 && count <D && a[i][j+1]>0) dfs(i,j+1,count+1);
        if(0<j && count <D && a[i][j-1]>0) dfs(i,j-1,count+1);
    }
    int maxVal=0;
    int D;
    int R;
    int C;
    int[][] a;
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