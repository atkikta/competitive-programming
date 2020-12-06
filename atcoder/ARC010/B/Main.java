import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int[] mtd = new int[13];
        mtd[1] = 0;
        mtd[2] = 31;
        mtd[3] = mtd[2]+29;
        mtd[4] = mtd[3]+31;
        mtd[5] = mtd[4]+30;
        mtd[6] = mtd[5]+31;
        mtd[7] = mtd[6]+30;
        mtd[8] = mtd[7]+31;
        mtd[9] = mtd[8]+31;
        mtd[10] = mtd[9]+30;
        mtd[11] = mtd[10]+31;
        mtd[12] = mtd[11]+30;
        int[] isholiday = new int[367]; // 0,1-366
        for (int i = 1; i < isholiday.length; i++) {
            if(i%7==1) isholiday[i] = 1;
            if(i%7==0) isholiday[i] = 1;
        }
        for (int i = 0; i < N; i++) {
            String h = ns();
            String[] md = h.split("/");
            int hd = mtd[Integer.parseInt(md[0])]+Integer.parseInt(md[1]);
            for (int j = hd; j < isholiday.length; j++) {
                if(isholiday[j]==0) {
                    isholiday[j] = 1;
                    break;
                }
            }
        }
        long ans = 0;
        long count = 0;
        boolean isin = false;
        for (int i = 1; i < isholiday.length; i++) {
            if(isholiday[i]==1){
                isin=true;
                count++;
            }else{
                isin=false;
                count = 0;
            }
            ans = Math.max(ans,count);
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