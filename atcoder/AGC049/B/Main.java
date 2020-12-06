import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        String s = ns();
        String t = ns();
        int[] ta = new int[N];
        int[] sa = new int[N];
        int counts1 = 0;
        int countt1 = 0;
        ArrayDeque<Integer> loc1s = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if(s.charAt(i)=='1') {
                loc1s.addLast(i);
                sa[i] = 1;
                counts1++;
            }
            if(t.charAt(i)=='1'){
                ta[i] = 1;
                countt1++;
            }
        }
        if(counts1-countt1<0 || (counts1-countt1)%2!=0){
            out.println(-1);
            return;
        }
        long ans = 0;
        for (int i = 0; i < N; i++) {
            // System.out.println(i);
            // System.out.println(Arrays.toString(sa));
            if(sa[i]==0 && ta[i]==0) continue;
            if(sa[i]==1 && ta[i]==1){
                if(loc1s.size()<1){
                    out.println(-1);
                    return;
                }
                loc1s.poll();
            }
            if(sa[i]==1 && ta[i]==0){
                if(i<N-1){
                    if(sa[i+1]==1&&ta[i+1]==0){
                        ans++;
                        sa[i]=0;
                        sa[i+1]=0;
                        if(loc1s.size()<2){
                            out.println(-1);
                            return;
                        }
                        loc1s.poll();
                        loc1s.poll();
                        i++;
                    }else if(sa[i+1]==0&&ta[i+1]==0){
                        if(loc1s.size()<2){
                            out.println(-1);
                            return;
                        }
                        int next1 = loc1s.poll();
                        next1 = loc1s.poll();
                        ans += (next1-(i+1));
                        ans += 1;
                        sa[next1]=0;
                        sa[i]=0;
                        i++;
                    }else if(sa[i+1]==1&&ta[i+1]==1){
                        if(loc1s.size()<3){
                            out.println(-1);
                            return;
                        }
                        int next1 = loc1s.poll();
                        next1 = loc1s.poll();
                        ans++;
                        next1 = loc1s.poll();
                        ans += (next1 - (i+1));
                        sa[i]=0;
                        sa[i+1]=0;
                        sa[next1]=0;
                        i++;
                    }else if(sa[i+1]==0&&ta[i+1]==1){
                        if(loc1s.size()<3){
                            out.println(-1);
                            return;
                        }
                        int next1 = loc1s.poll();
                        next1 = loc1s.poll();
                        sa[next1] = 0;
                        ans += (next1 - (i+1));
                        ans++;
                        sa[i] = 0;
                        sa[i+1] = 0;
                        next1 = loc1s.poll();
                        sa[next1]=0;
                        ans += (next1 - (i+1));
                        sa[i+1]=1;
                        i++;
                    }
                }else{
                    out.println(-1);
                    return;
                }
            }
            if(sa[i]==0&&ta[i]==1){
                if(loc1s.size()<1){
                    out.println(-1);
                    return;
                }
                int next1 = loc1s.poll();
                ans+= (next1-(i));
                sa[i]=1;
                sa[next1]=0;
            }
        }
 
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