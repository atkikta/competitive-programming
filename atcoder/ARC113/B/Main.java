import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        long a = nl();
        long b = nl();
        long c = nl();
        if(a%10==0 || a%10==1||a%10==5||a%10==6){
            out.println(a%10);
            return;
        }else if(a%10==4){
            if(b%2==0) out.println(6);
            else out.println(4);
            return;
        }else if(a%10==9){
            if(b%2==0) out.println(1);
            else out.println(9);
            return;
        }else{
            long time = MathLib.pow_mod(b,c,4);
            if(time==0) time = 4;
            // System.out.println(time);
            int base = 1;
            for (long i = 0; i < time; i++) {
                base *= (a%10);
            }
            // System.out.println(base);
            out.println(base%10);
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


class MathLib{
    private static long safe_mod(long x, long m){
        x %= m;
        if(x<0) x += m;
        return x;
    }

    private static long[] inv_gcd(long a, long b){
        a = safe_mod(a, b);
        if(a==0) return new long[]{b,0};

        long s=b, t=a;
        long m0=0, m1=1;
        while(t>0){
            long u = s/t;
            s -= t*u;
            m0 -= m1*u;
            long tmp = s; s = t; t = tmp;
            tmp = m0; m0 = m1; m1 = tmp;
        }
        if(m0<0) m0 += b/s;
        return new long[]{s,m0};
    }

    public static long pow_mod(long x, long n, int m){
        assert n >= 0;
        assert m >= 1;
        if(m == 1)return 0L;
        x = safe_mod(x, m);
        long ans = 1L;
        while(n > 0){
            if((n&1) == 1) ans = (ans * x) % m;
            x = (x*x) % m;
            n >>>= 1;
        }
        return ans;
    }

    public static long[] crt(long[] r, long[] m){
        // find x = r[i] mod m[i] for all i
        // x = y mod z (0 <= y < z = lcm(m))
        // returns [y, z]
        // if no solution returns [0,0]
        assert(r.length == m.length);
        int n = r.length;

        long r0=0, m0=1;
        for(int i=0; i<n; i++){
            assert(1 <= m[i]);
            long r1 = safe_mod(r[i], m[i]), m1 = m[i];
            if(m0 < m1){
                long tmp = r0; r0 = r1; r1 = tmp;
                tmp = m0; m0 = m1; m1 = tmp;
            }
            if(m0%m1 == 0){
                if(r0%m1 != r1) return new long[]{0,0};
                continue;
            }

            long[] ig = inv_gcd(m0, m1);
            long g = ig[0], im = ig[1];

            long u1 = m1/g;
            if((r1-r0)%g != 0) return new long[]{0,0};

            long x = (r1-r0) / g % u1 * im % u1;

            r0 += x * m0;
            m0 *= u1;
            if(r0<0) r0 += m0;
            //System.err.printf("%d %d\n", r0, m0);
        } 
        return new long[]{r0, m0};
    }
    public static long floor_sum(long n, long m, long a, long b){
        long ans = 0;
        if(a >= m){
            ans += (n-1) * n * (a/m) / 2;
            a %= m;
        }
        if(b >= m){
            ans += n * (b/m);
            b %= m;
        }

        long y_max = (a*n+b) / m;
        long x_max = y_max * m - b;
        if(y_max == 0) return ans;
        ans += (n - (x_max+a-1)/a) * y_max;
        ans += floor_sum(y_max, a, m, (a-x_max%a)%a);
        return ans;
    }
    public static long modinv(long a, int m) {
		long b = m;
		long u = 1;
		long v = 0;
		long tmp = 0;
 
		while (b > 0) {
			long t = a / b;
			a -= t * b;
			tmp = a;
			a = b;
			b = tmp;
 
			u -= t * v;
			tmp = u;
			u = v;
			v = tmp;
		}
 
		u %= m;
		if (u < 0) u += m;
		return u;
	}
    public static long carryDecimal(String s, int afterdecimal){
        if(!s.contains(".")){
            long ret = Long.valueOf(s);
            for (int i = 0; i < afterdecimal; i++) {
                ret *= 10;
            }
            return ret;
        }
        long res = 0;
        long posneg = 1;
        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '-') posneg = -1;
            else if(c == '.'){
                for (int j = 0; j < afterdecimal; j++) {
                    i++;
                    if(i < s.length()) res = res * 10 + (s.charAt(i) - '0');
                    else res = res * 10;
                }
                break;
            }
            else{
                res = res *10 + (c - '0');
            }
        }
        return res * posneg;
    }

}