import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int Q = ni();
        int[] A = new int[N];
        int[] B = new int[N];
        ArrayList<TreeSet<Integer>> score = new ArrayList<>();
        TreeSet<Integer> all = new TreeSet<>((x,y)->(A[x]==A[y]?x-y:A[x]-A[y]));
        for (int i = 0; i < 2*100000; i++) {
            score.add(new TreeSet<>((x,y)->(A[y]==A[x]?y-x:A[y]-A[x])));
        }
        for (int i = 0; i < N; i++) {
            int a = ni();
            int b = ni()-1;
            A[i] = a;
            B[i] = b;
        }
        for (int i = 0; i < N; i++) {
            score.get(B[i]).add(i);
        }
        for (int i = 0; i < score.size(); i++) {
            if(score.get(i).size()>0){
                all.add(score.get(i).first());
            }
        }
        // System.out.println(all.toString());
        for (int i = 0; i < Q; i++) {
            int c = ni()-1;
            int d = ni()-1;
            if(score.get(B[c]).first()==c){
                all.remove(c);
                score.get(B[c]).remove(c);
                if(score.get(B[c]).size()>0)all.add(score.get(B[c]).first());
            }else{
                score.get(B[c]).remove(c);

            }
            if(score.get(d).size()>0) all.remove(score.get(d).first());
            score.get(d).add(c);
            all.add(score.get(d).first());
            B[c] = d;
            out.println(A[all.first()]);
            // System.out.println(all.toString());
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