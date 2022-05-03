import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        long N = nl();
        long[] d26 = new long[15];
        d26[0] = 1;
        for (int i = 1; i < 15; i++) {
            d26[i] = d26[i-1]*26;
        }
        char []alphabet = new char[26];
        char c = 'a';
        for (int i = 0; i < 26; i++){
            alphabet[i] = c++;
        }
        N = N-1;
        ArrayList<Character> ans = new ArrayList<>();
        for (int i = 1; i < d26.length; i++) {
            if(N-d26[i] >= 0){
                N -= d26[i];
            }else{
                for (int j = i; j >=1; j--) {
                    // System.out.println(N);
                    // System.out.println((N/d26[j-1]));
                    ans.add(alphabet[(int)(N/d26[j-1])]);
                    N = N % d26[j-1];
                    // N -= d26[j-1] * ((N-1)/d26[j] + 1);
                }
                break;
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            out.print(ans.get(i));
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