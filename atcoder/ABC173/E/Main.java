import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int K = ni();
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int a = ni();
            A.add(a);
            if(a<0) neg.add(a);
            else pos.add(a);
        }
        boolean ok = false;
        if(pos.size()>0){
            if(N==K){
                ok = (neg.size()%2==0) ;
            }else{
                ok = true;
            }
        }else{
            ok = (K%2==0);
        }
        if(!ok){
            Collections.sort(A,
             (x,y)->Integer.valueOf(Math.abs(x)).compareTo(Integer.valueOf(Math.abs(y))));
            int ans = 1;
            for (int i = 0; i < K; i++) {
                ans = mul(ans, A.get(i));
            }
            if(ans<0) ans += mod;
            out.println(ans);
            return;
        }else{
            Collections.sort(pos);
            Collections.sort(neg,Comparator.reverseOrder());
            int ans = 1;
            if(K%2==1){
                ans = mul(ans, pos.get(pos.size()-1));
                pos.remove(pos.size()-1);
            }
            ArrayList<Long> ps = new ArrayList<>();
            while(pos.size()>=2){
                long p = pos.get(pos.size()-1);
                pos.remove(pos.size()-1);
                p*= pos.get(pos.size()-1);
                pos.remove(pos.size()-1);
                ps.add(p);
            }
            while(neg.size()>=2){
                long p = neg.get(neg.size()-1);
                neg.remove(neg.size()-1);
                p*= neg.get(neg.size()-1);
                neg.remove(neg.size()-1);
                ps.add(p);
            }
            Collections.sort(ps, Comparator.reverseOrder());
            for (int i = 0; i < K/2; i++) {
                ans = mul(ans, (int)(ps.get(i)%mod));
            }
            if(ans<0) ans += mod;
            out.println(ans);
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