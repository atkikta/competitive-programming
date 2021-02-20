import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int N = ni();
        long M = nl();
        ArrayList<Integer> A = new ArrayList<>();
        long[] a = new long[N];
        for (int i = 0; i < N; i++) {
            int aa = ni();
            a[i] = aa;
            A.add(aa);
        }
        BinarySearch<Integer> bs = new BinarySearch<>();
        Collections.sort(A);
        Arrays.parallelSort(a);
        int left = 1;
        int right = A.get(A.size()-1) * 2 + 1;
        while(right-left>1){
            int mid = (left+right)/2;
            long countGEmid = 0;
            for (int i = 0; i < N; i++) {
                // System.out.println(String.format("%d %d", mid, bs.lowerBound(A, mid-A.get(i))));
                countGEmid += A.size() - bs.lowerBound(A, mid-A.get(i));
            }
            if(countGEmid<M){
                right = mid;
            }else{
                left = mid;
            }
        }
        // System.out.println(left);
        long[] csum = new long[N+1];
        for (int i = 0; i < N; i++) {
            csum[i+1] = csum[i] + A.get(i);
        }
        // System.out.println(Arrays.toString(csum));
        long ans = 0;
        long numadded = 0;
        for (int i = 0; i < N; i++) {
            int idx = binarySearch(a, left - a[i] - 0.5);
            int countGE = A.size() - idx;
            numadded += countGE;
            ans += A.get(i) *1L* countGE;
            ans += (csum[N]-csum[idx]);
        }
        ans -= (numadded-M) * left;
        out.println(ans);
    }
    static int binarySearch(long[] array, double val) {
		int start = -1;
		int end = array.length;
 
		while (Math.abs(end - start) > 1) {
			int mid = (end + start) / 2;
			if (mid == array.length) {
				return mid;
			}
			if (array[mid] >= val) {
				end = mid;
			} else {
				start = mid;
			}
		}
		return end;
	}
    class BinarySearch<T extends Comparable<? super T>>{
        int upperBound(ArrayList<T> list, T target){
            int i = Collections.binarySearch(list, target, (x,y)->(x.compareTo(y) > 0) ? 1 : -1);
            return ~i;
        }
        int lowerBound(ArrayList<T> list, T target){
            int i = Collections.binarySearch(list, target, (x,y)->(x.compareTo(y) >= 0) ? 1 : -1);
            return ~i;
        }
    }
    final int mod = 1000000007;
    final BigInteger MOD = BigInteger.valueOf(mod);
    
    long gcd(long num1,long num2) {
        if(num2 == 0) return num1;
        else return gcd(num2 , num1 % num2 );
    }
    long lcm(long a, long b){
        return (a / gcd(a, b)) * b;
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
    void print2DArray(int[][] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
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