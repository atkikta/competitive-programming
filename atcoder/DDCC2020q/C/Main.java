import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int H = ni();
        int W = ni();
        int K = ni();
        int[][] grid = new int[H][W];
        int[] numinrow = new int[H];
        for (int i = 0; i < H; i++) {
            String s = ns();
            for (int j = 0; j < W; j++) {
                if(s.charAt(j)=='#') {
                    grid[i][j] =1;
                    numinrow[i]++;
                }
            }
        }
        ArrayDeque<ArrayList<Integer>> que = new ArrayDeque<>();
        boolean isin = false;
        int currentrow = 0;
        for (int i = 0; i < H; i++) {

            if(isin && numinrow[i]>0){
                ArrayList<Integer> rect = new ArrayList<>();
                rect.add(currentrow);
                rect.add(0);
                rect.add(i);
                rect.add(W);
                que.add(rect);
                currentrow=i;
            }
            if(numinrow[i]>0){
                isin=true;
            }

        }
        que.add(new ArrayList<>(Arrays.asList(currentrow,0,H,W)));
        // for (ArrayList<Integer> a : que) {
        //     System.out.println(a.toString());
        // }
        System.out.println();
        int numrcut = que.size();
        for (int i = 0; i < numrcut; i++) {
            var rect = que.removeFirst();
            int top = rect.get(0);
            int bot = rect.get(2);
            boolean first = false;
            int currentcol = 0;
            for (int j = 0; j < W; j++) {
                boolean isinc = false;
                for (int j2 = top; j2 < bot; j2++) {
                    if(grid[j2][j]==1) isinc= true;
                }
                if(first && isinc){
                    ArrayList<Integer> newrect = new ArrayList<>();
                    newrect.add(top);
                    newrect.add(currentcol);
                    newrect.add(bot);
                    newrect.add(j);
                    que.add(newrect);
                    currentcol = j;
                }
                if(isinc) first = true;
            }
            que.add(new ArrayList<>(Arrays.asList(top,currentcol,bot,W)));
        }
        // for (ArrayList<Integer> a : que) {
        //     System.out.println(a.toString());
        // }
        int[][] ans = new int[H][W];
        int c = 1;
        for (ArrayList<Integer> a : que) {
            // System.out.println(c);
            for (int i = a.get(0); i < a.get(2); i++) {
                for (int j = a.get(1); j < a.get(3); j++) {
                    ans[i][j] = c;
                }
            }
            if(a.get(0)!=a.get(2) || a.get(1)!=a.get(3))c++;
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                out.print(ans[i][j] + " ");
            }
            out.println();
        }
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