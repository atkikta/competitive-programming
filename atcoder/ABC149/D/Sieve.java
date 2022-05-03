import java.util.ArrayList;
import java.util.HashMap;

public class Sieve {
    private int n;
    private int[] f;
    public ArrayList<Integer> primes = new ArrayList<>();
    public Sieve(int N){
        this.n = N;
        this.f = new int[n+1];
        this.f[0] = -1; // 0 is not prime
        this.f[1] = -1; // 1 is not prime
        for (int i = 2; i <= N; i++) {
            if(f[i]!=0) continue;
            primes.add(i);
            f[i] = i;
            for (int j = i+i; j <=n; j+=i) {
                if(f[j] == 0) f[j] = i;
            }
        }
    }
    public boolean isPrime(int i){
        return f[i] == i;
    }
    public ArrayList<Integer> factorList(int i){
        ArrayList<Integer> res = new ArrayList<>();
        while(i!=1){
            res.add(f[i]);
            i/=f[i];
        }
        return res;
    }
    public HashMap<Integer,Integer> factorCount(int i){
        HashMap<Integer,Integer> res = new HashMap<>();
        while(i!=1){
            res.putIfAbsent(f[i],0);
            res.put(f[i],res.get(f[i])+1);
            i /= f[i];
        }
        return res;
    }
}