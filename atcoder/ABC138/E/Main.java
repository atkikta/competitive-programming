import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        String s = ns();
        String t = ns();
        String ss = s+s;
        HashMap<Character,ArrayList<Integer>> smap = new HashMap<>();
        for (int i = 0; i < ss.length(); i++) {
            smap.putIfAbsent(ss.charAt(i), new ArrayList<>());
            smap.get(ss.charAt(i)).add(i);
        }

        int sc = 0;
        long ans = 0;
        for (int i = 0; i < t.length(); i++) {
            char ti = t.charAt(i);
            if(!smap.containsKey(ti)){
                ans = -1;
                break;
            }
            ArrayList<Integer> locs = smap.get(ti);
            // System.out.println(locs);
            int lb = Collections.binarySearch(locs, sc);
            // System.out.println(lb);
            if(lb >= 0) lb = lb;
            else lb = ~lb;
            // System.out.println(lb);
            ans += locs.get(lb)+1-sc;
            // System.out.println(ans);
            sc = locs.get(lb)+1;
            if(sc>s.length()){
                sc-=s.length();
            }
            // System.out.println(sc);
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