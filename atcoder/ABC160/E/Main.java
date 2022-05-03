import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int X = ni();
        int Y = ni();
        int A = ni();
        int B = ni();
        int C = ni();
        
        PriorityQueue<Integer> red = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> green = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> white = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < A; i++) {
            red.add(ni());
        }
        for (int i = 0; i < B; i++) {
            green.add(ni());
        }
        for (int i = 0; i < C; i++) {
            white.add(ni());
        }
        for (int i = 0; i < X; i++) {
            white.add(red.poll());
        }
        for (int i = 0; i < Y; i++) {
            white.add(green.poll());
        }
        long ans = 0;
        for (int i = 0; i < X+Y; i++) {
            ans += white.poll();
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