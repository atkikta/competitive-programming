class DigDP {
    int[] N;
    DigDP(int[] N){
        this.N = N;
    }
    int run() {
        int[][][] dp = new int[N.length+1][2][N.length+1];
        dp[0][0][0] = 1;
        for (int i = 0; i < N.length; i++) {
            int dig = N[i];
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < N.length; k++) {
                    for (int x = 0; x < ((j==1)?9:dig)+1; x++) {
                        dp[i+1][(j==1||x<dig)?1:0][(x==1)?k+1:k] += dp[i][j][k];
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N.length+1; i++) {
            ans += dp[N.length][0][i]*i + dp[N.length][1][i]*i; 
        }
        return ans;
    }
}
