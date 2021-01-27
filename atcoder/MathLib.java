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
}