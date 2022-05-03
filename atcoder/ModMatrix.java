class ModPowMatrix {
    final int mod;
    ModPowMatrix(int mod){
        this.mod = mod;
    }
    int[][] pow(int[][] a, long K){
        int N = a.length;
        int[][] ret = new int[N][N];
        for (int i = 0; i < N; i++) {
            ret[i][i] = 1;
        }
        int[][] ai = a;
        for (long i = 0; Math.pow(2, i) <= K; i++) {
            if((K>>i & 1)==1){
                ret = modMultArray(ret, ai);
            }
            ai = modMultArray(ai, ai);
        }
        return ret;
    }

    int[][] modMultArray(int[][] a, int[][] b){
        int N = a.length;
        int[][] ret = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cij = 0;
                for (int k = 0; k < N; k++) {
                    cij = add(cij, mul(a[i][k],  b[k][j]));
                }
                ret[i][j] = cij;
            }
        }   
        return ret;
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

}
