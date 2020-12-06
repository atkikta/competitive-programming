import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        String s = ns();     
        ArrayList<String> cards = new ArrayList<>();
        int at = 0;
        while(at<s.length()) {
            String next;
            if(at+3 < s.length()+1 && s.substring(at+1, at+3).equals("10")){
                next = s.substring(at, at+3);
                at += 3;
            }else{
                next = s.substring(at, at+2);
                at += 2;
            }
            cards.add(String.valueOf(next));
        }

        ArrayList<String> sp = new ArrayList<>();
        ArrayList<String> he = new ArrayList<>();
        ArrayList<String> di = new ArrayList<>();
        ArrayList<String> cl = new ArrayList<>();
        int num = Integer.MAX_VALUE;
        int sf = 0;
        for (String c : cards) {
            if(c.equals("S10")||c.equals("SJ")||c.equals("SQ")||c.equals("SK")||c.equals("SA")){
                sf++;
            }else{
                sp.add(c);
            }
            if(sf>=5){
                num = Math.min(num, sp.size());
                break;
            }
        }
        sf = 0;
        for (String c : cards) {
            if(c.equals("H10")||c.equals("HJ")||c.equals("HQ")||c.equals("HK")||c.equals("HA")){
                sf++;
            }else{
                he.add(c);
            }
            if(sf>=5){
                num = Math.min(num, he.size());
                break;
            }
        }
        sf = 0;
        for (String c : cards) {
            if(c.equals("D10")||c.equals("DJ")||c.equals("DQ")||c.equals("DK")||c.equals("DA")){
                sf++;
            }else{
                di.add(c);
            }
            if(sf>=5){
                num = Math.min(num, di.size());
                break;
            }
        }
        sf = 0;
        for (String c : cards) {
            if(c.equals("C10")||c.equals("CJ")||c.equals("CQ")||c.equals("CK")||c.equals("CA")){
                sf++;
            }else{
                cl.add(c);
            }
            if(sf>=5){
                num = Math.min(num, cl.size());
                break;
            }
        }
        if(num==0){
            out.println(0);
            return;
        }
        if(num == sp.size()){
            for (int i = 0; i < sp.size(); i++) {
                out.print(sp.get(i));
            }
            out.println();
            return;
        }
        if(num == he.size()){
            for (int i = 0; i < he.size(); i++) {
                out.print(he.get(i));
            }
            out.println();
            return;
        }
        if(num == di.size()){
            for (int i = 0; i < di.size(); i++) {
                out.print(di.get(i));
            }
            out.println();
            return;
        }
        if(num == cl.size()){
            for (int i = 0; i < cl.size(); i++) {
                out.print(cl.get(i));
            }
            out.println();
            return;
        }
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