import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        String S = ns();
        int[] count = new int[26];
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i)-'a'] ++;
        }
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < 26; i++) {
            if(count[i] % 2!=0){
                que.add(1);
                count[i] = count[i]-1;
            }
        }
        if(que.size()==0 || que.size()==1){
            out.println(S.length());
            return;
        }
        for (int i = 0; i < 26; i++) {
            if(count[i]%2==0){
                while(count[i]>0){
                    int minlen = que.poll();
                    que.add(minlen+2);
                    count[i] -= 2;
                }

            }
        }
        out.println(que.poll());
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