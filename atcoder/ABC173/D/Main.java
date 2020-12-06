import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            a.add(ni());
        }
        Collections.sort(a, Comparator.reverseOrder());
        Deque<Integer> aq = new ArrayDeque<>();
        for (int i = 0; i < a.size(); i++) {
            aq.addLast(a.get(i));
        }
        PriorityQueue<ArrayList<Integer>> que = new PriorityQueue<>((x,y)->y.get(0).compareTo(x.get(0)));
        int first = aq.removeFirst();
        que.add(new ArrayList<>(Arrays.asList(first, first,first)));
        long ans = 0;
        while(aq.size()>0){
            int friendly = aq.removeFirst();
            var t = que.poll();
            ans += t.get(0);
            int nei1 = t.get(1);
            int nei2 = t.get(2);
            var nextTriplet1 = new ArrayList<Integer>(Arrays.asList(Math.min(nei1,friendly), friendly,nei1));
            var nextTriplet2 = new ArrayList<Integer>(Arrays.asList(Math.min(nei2,friendly), friendly,nei2));
            que.add(nextTriplet1);
            que.add(nextTriplet2);
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