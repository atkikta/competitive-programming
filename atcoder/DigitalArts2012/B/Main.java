import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

 
public class Main {
 
    void solve() throws IOException {
        String s = ns();
        int count = 0;
        base = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) - 'a' + 1;
            base.add(s.charAt(i) - 'a' + 1);
        }
        if(count==1 || count == 26*20){
            out.println("NO");
            return;
        }
        boolean allsame = true;
        for (int i = 0; i < base.size(); i++) {
            for (int j = 0; j < base.size(); j++) {
                if(base.get(i)!=base.get(j)) allsame =false;
            }
        }
        if(allsame && count == base.size()){
            base.set(0, base.get(0)+1);
            base.remove(base.size()-1);
        }else if(allsame && (count == base.size()*26)||(base.size()==1)){
            base.set(base.size()-1, base.get(base.size()-1)-1);
            base.add(1);
        }else if(allsame && base.size() == 20){
            base.set(0, base.get(0)-1);
            base.set(1, base.get(1)+1);
        }else if(allsame){
            base.set(base.size()-1, base.get(base.size()-1)-1);
            base.add(1);            
        }else{
            boolean swaped = false;
            for (int i = 0; i < base.size(); i++) {
                if(swaped) break;
                for (int j = 0; j < base.size(); j++) {
                    if(base.get(i) != base.get(j)){
                        int val = base.get(i);
                        base.set(i,base.get(j));
                        base.set(j,val);
                        swaped = true;
                        break;
                    }
                }
            }
        }
        for(Integer i : base){
            char c = 'a';
            c += (i-1);
            out.print(c);
        }
        out.println();
    }
    void dfs(ArrayList<Integer> state, int count){
        if(state.size()>20) return;
        if(found) return;
        int sum = 0;
        for (int i = 0; i < state.size(); i++) {
            sum += state.get(i);
        }
        if(sum == count) {
            if(!state.equals(base)){
                for(Integer i : state){
                    char c = 'a';
                    c += (i-1);
                    out.print(c);
                }
                out.println();
                found = true;
                return;
            }
        }
        for (int i = 1; i <= 26; i++) {
            if(!found && sum+i <=count) {
                state.add(i);
                dfs(state, count);
                state.remove(state.size()-1);
            }else{
                return;
            }
        }
    }
    boolean found = false;
    ArrayList<Integer> base;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
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