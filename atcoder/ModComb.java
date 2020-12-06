import java.math.BigInteger;
public class ModComb{
    int mod;
    int N;
    int[] nfac;
    int[] nfacinv;
    ModComb(int n, int mod){
        this.mod = mod;
        final BigInteger MOD = BigInteger.valueOf(mod);
        this.N=n;
        this.nfac = new int[n+1];
        this.nfacinv = new int[n+1];
        nfac[0] = 1;
        for (int i = 1; i < n+1; i++) {
            nfac[i] = (int)((nfac[i-1] * 1L * i)%mod);
        }
        int inv = BigInteger.valueOf((long)nfac[n]).modInverse(MOD).intValue();
        this.nfacinv[n] = inv;
        for (int i = n; i > 0; i--) {
            nfacinv[i-1] = (int)((nfacinv[i] * 1L * i)%mod);
        }
    }
    int comb(int n, int r){
        int ret = (int)((nfac[n] * 1L * nfacinv[r]) % mod);
        ret = (int)((ret * 1L * nfacinv[n-r]) % mod);
        return ret;
    }
}