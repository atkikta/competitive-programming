import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        int[] twos = new int[N];
        int[] fivs = new int[N];
        for (int i = 0; i < N; i++) {
            String s = ns();
            long val = 0;
            if(s.contains(".")){
                val = 0;
                int dig = 0;
                for (int j = 0; j < s.length(); j++) {
                    dig++;
                    if(s.charAt(j)=='.') break;
                    val = val*10 + (s.charAt(j) - '0');
                }
                for (int j = dig; j < dig+9; j++) {
                    if(j<s.length()) val = val*10 +(s.charAt(j)-'0');
                    else val = val * 10;
                }
                // System.out.println(val);
            }else{
                val = Long.valueOf(s) * 1000_000_000;
                // System.out.println(val);
            }
            long val2 = val;
            while(val2 % 2 == 0){
                twos[i]++;
                val2 = val2/2;
            }
            long val5 = val;
            while(val5 % 5 ==0){
                fivs[i]++;
                val5 = val5/5;
            }
        }
        // System.out.println(Arrays.toString(twos));
        // System.out.println(Arrays.toString(fivs));
        int[][] count = new int[41][41];
        for (int i = 0; i < N; i++) {
            count[twos[i]][fivs[i]]++;
        }
        long ans = 0;
        for (int i = 0; i < 41; i++) {
            for (int j = 0; j < 41; j++) {
                for (int k = 0; k < 41; k++) {
                    for (int l = 0; l < 41; l++) {
                        if(i+k>=18 && j+l>=18){
                            if(i==k && j==l) {
                                ans += count[i][j]* 1L *(count[i][j]-1);
                                // if(count[i][j]>0)System.out.println(String.format("%d %d %d %d %d",1,i,j,k,l));
                            }
                            else {
                                ans += count[i][j] * 1L * count[k][l];
                                // if(count[i][j]>0&&count[k][l]>0)System.out.println(String.format("%d %d %d %d %d",2,i,j,k,l));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans/2);
    }

    final int mod = 1000000007;
    final BigInteger MOD = BigInteger.valueOf(mod);
    int upperBound(ArrayList<Long> list, Long target){
        int i = Collections.binarySearch(list, target, new UpperBoundComparator<Long>());
        return ~i;
    }
    class UpperBoundComparator<T extends Comparable<? super T>> implements Comparator<T>{
        public int compare(T x, T y){
            return (x.compareTo(y) > 0) ? 1 : -1;
        }
    }
    int lowerBound(ArrayList<Long> list, Long target){
        int i = Collections.binarySearch(list, target, new LowerBoundComparator<Long>());
        return ~i;
    }
    class LowerBoundComparator<T extends Comparable<? super T>> implements Comparator<T>{
        public int compare(T x, T y){
            return (x.compareTo(y) >= 0) ? 1 : -1;
        }
    }
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