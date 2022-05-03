public class LoopSkip{
    long[][] pre;
    public LoopSkip(long MaxPeriod){
        this.pre = new long[(int)MaxPeriod][2];
        for (int i = 0; i < MaxPeriod; i++) {
            for (int j = 0; j < 2; j++) {
                pre[i][j] = -1;
            }
        }
    }
    public long run(long numStep, long initVal, long update){
        long ans = 0;
        long X = initVal;
        long N = numStep;
        for (long i = 0; i < N; i++) {
            // sum up X
            ans += X;
            if(pre[(int)X][0] != -1){
                long period = i-pre[(int)X][0];
                long sum = ans - pre[(int)X][1];
                long res = N-1-i;
                ans+=res/period*sum;
                i+=res/period*period;
            }
            pre[(int)X][0] = i;
            pre[(int)X][1] = ans;
            // update X
            X = X*X%update;
        }
        return ans;
    }
}