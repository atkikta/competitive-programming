import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        Random rand = new Random();
        int d = ni();
        int[] c = new int[26];
        for (int i = 0; i < 26; i++) {
            c[i] = ni();
        }
        int[][] s = new int[d][26];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < 26; j++) {
                s[i][j] = ni();
            }
        }

        int count = 0;
        long maxscore = 0;
        int[] best = new int[d];
        while(count<10000){
            int[] t = new int[d];
            for (int i = 0; i < t.length; i++) {
                t[i] = rand.nextInt(26);
            }
            long score = 0;
            int[] last = new int[26];
            for (int i = 1; i <= d; i++) {
                score += s[i-1][t[i-1]];
                last[t[i-1]] = i;
                for (int j = 0; j < 26; j++) {
                    score -= c[j]*(i-last[j]);
                }
            }
            if(maxscore < score){
                System.out.println(score);
                maxscore = score;
                best = t;
            }
            count++;
        }
        for (int i = 0; i < d; i++) {
            out.println(best[i]+1);
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