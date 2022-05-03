import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int[][] t = new int[N][N];
        for (int i = 0; i < N; i++) {
            int a = ni();
            for (int j = 0; j < N; j++) {
                t[i][j] =-1;
            }
            for (int j = 0; j < a; j++) {
                int x = ni()-1;
                int y = ni();
                t[i][x] = y;
            }
        }
        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < N; j++) {
        //         System.out.print(t[i][j]);
        //     }
        //     System.out.println("");
        // }

        int ans = 0;
        for (int i = 0; i <= (1<<(N))-1; i++) {
            boolean isfeasible = true;
            for (int j = 0; j < N; j++) {
                boolean ishonest = ((i>>j) & 1)==1;
                for (int k = 0; k < N; k++) {
                    if(ishonest){
                        if(t[j][k]==0 && ((i>>k)&1)==1) isfeasible = false;
                        if(t[j][k]==1 && ((i>>k)&1)==0) isfeasible = false;
                    }
                    // if(!ishonest){
                    //     if(t[j][k]==1 && ((i>>k)&1)==1) isfeasible = false;  
                    //     if(t[j][k]==0 && ((i>>k)&1)==0) isfeasible = false;  
                    // } 
                }
            }
            if(isfeasible){
                int res =0;
                for (int j = 0; j < N; j++) {
                    if(((i>>j) & 1)==1) res ++;
                }
                ans = Math.max(ans,res);
            }
            // System.out.println(i);
            // System.out.println(isfeasible);
        }
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