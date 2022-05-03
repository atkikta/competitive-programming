import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        HashMap<Integer, Integer> oddmap = new HashMap<>();
        HashMap<Integer, Integer> evemap = new HashMap<>();
        int oddcount =0;
        int evecount =0;
        for (int i = 0; i < N; i++) {
            int v = ni();
            if(i%2==0){
                evecount++;
                evemap.putIfAbsent(v, 0);
                evemap.put(v, evemap.get(v)+1);
            }else{
                oddcount++;
                oddmap.putIfAbsent(v, 0);
                oddmap.put(v, oddmap.get(v)+1);
            }
        }
        int maxeve = 0;
        int valeve = -1;
        int maxodd = 0;
        int valodd = -1;
        for (Map.Entry<Integer, Integer> entry : evemap.entrySet() ){
            if(maxeve < entry.getValue()){
                maxeve = entry.getValue();
                valeve = entry.getKey();
            }
        }
        for (Map.Entry<Integer, Integer> entry : oddmap.entrySet()) {
            if(maxodd < entry.getValue()){
                maxodd = entry.getValue();
                valodd = entry.getKey();
            }
        }
        if((evemap.size()==1 && oddmap.size()==1) && valeve == valodd){
            out.println(oddcount + evecount - Math.max(maxeve, maxodd));
            return;
        }
        int maxpair = 0;
        for (Map.Entry<Integer, Integer>  entry : evemap.entrySet()) {
            if(valodd != entry.getKey()) maxpair = Math.max(maxpair, maxodd + entry.getValue());
        }
        for (Map.Entry<Integer, Integer>  entry : oddmap.entrySet()) {
            if(valeve != entry.getKey()) maxpair = Math.max(maxpair, maxeve + entry.getValue());
        }
        long ans = oddcount + evecount - maxpair;
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