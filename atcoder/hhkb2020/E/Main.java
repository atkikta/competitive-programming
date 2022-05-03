import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int H = ni();
        int W = ni();
        int[][] grid = new int[H][W];
        int count0 = 0;
        for (int i = 0; i < H; i++) {
            String s = ns();
            for (int j = 0; j < W; j++) {
                if(s.charAt(j)=='#') grid[i][j] = 1;
                if(s.charAt(j)=='.') count0++;
            }
        }
        int [] pow2 = new int[H*W+1];
        pow2[0]=1;
        for (int i = 1; i < pow2.length; i++) {
            pow2[i] = mul(pow2[i-1],2);
        }

        int[][] cright = new int[H][W];
        for (int i = 0; i < H; i++) {
            int w=0;
            int count = 0;
            while(w<=W-1){
                if(grid[i][w]==1) count=0;
                cright[i][w] = count;
                if(grid[i][w]==0)count++;
                w++;
            }
        }
        int[][] cleft = new int[H][W];
        for (int i = 0; i < H; i++) {
            int w=W-1;
            int count = 0;
            while(w>=0){
                if(grid[i][w]==1) count=0;
                cleft[i][w] = count;
                if(grid[i][w]==0)count++;
                w--;
            }
        }
        int[][] cup = new int[H][W];
        for (int i = 0; i < W; i++) {
            int h=0;
            int count = 0;
            while(h<=H-1){
                if(grid[h][i]==1) count=0;
                cup[h][i] = count;
                if(grid[h][i]==0)count++;
                h++;
            }
        }
        int[][] cdown = new int[H][W];
        for (int i = 0; i < W; i++) {
            int h=H-1;
            int count = 0;
            while(h>=0){
                if(grid[h][i]==1) count=0;
                cdown[h][i] = count;
                if(grid[h][i]==0)count++;
                h--;
            }
        }
        // for (int i = 0; i < H; i++) {
        //     System.out.println(Arrays.toString(cleft[i]));
        // }
        // for (int i = 0; i < H; i++) {
        //     System.out.println(Arrays.toString(cright[i]));
        // }
        // for (int i = 0; i < H; i++) {
        //     System.out.println(Arrays.toString(cup[i]));
        // }
        // for (int i = 0; i < H; i++) {
        //     System.out.println(Arrays.toString(cdown[i]));
        // }
        int ans = mul(count0,pow2[count0]);
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(grid[i][j]==1) continue;
                int c = 1;
                c = add(c, cleft[i][j]);
                c = add(c, cright[i][j]);
                c = add(c, cup[i][j]);
                c = add(c, cdown[i][j]);
                ans = sub(ans, pow2[count0-c]);
            }
        }
        out.println(ans);
    }

    final int mod = 1000000007;
    final BigInteger MOD = BigInteger.valueOf(mod);

    int mul(int x, int y){
        int val = (int)((x * 1L * y) % mod);
        return val>=0 ? val : val+mod;
    }
    int add(int x, int y) {
        x += y;
        if(x < 0) x += mod;
        if(x>=mod) x -= mod;
        return x;
    }
    int sub(int x, int y){
        x = add(x,mod-y);
        if(x < 0) x += mod;
        if(x>=mod) x -= mod;
        return x;
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