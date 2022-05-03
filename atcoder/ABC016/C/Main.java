import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int M = ni();
        ArrayList<ArrayList<Integer>> graph= new ArrayList<>();
        for (int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = ni()-1;
            int b = ni()-1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i < N; i++) {
            HashSet<Integer> fof = new HashSet<>();
            for (Integer fn : graph.get(i)) {
                for(Integer ff: graph.get(fn)){
                    if(ff != i && (!graph.get(i).contains(ff))){
                        fof.add(ff);
                    }
                }
            }
            out.println(fof.size());
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
