public class Inchworm {
    long[] a;
    long K;
    int right = 0;
    public Inchworm(long[] a, long K){
        this.a = a;
        this.K = K;
    }
    public long walk(){
        long res = 0;
        long sum = 0;
        for (int left = 0; left < a.length; left++) {
            /* check if some condition is satisfied when right steps forward*/
            while(right < a.length && (sum + a[right] < K)){
                // System.out.println(String.format("%d %d %d", left, right, sum));
                /* actually step forward */
                sum+= a[right];
                ++right;
            }
            /* do something when right is largest that statisfies the condition*/
            res += right - left;

            /* do something before step left forward */
            if(left == right){ // if at the same position, step right altogether 
                right++;
            }else{
                sum -= a[left];
            }
        }
        // System.out.println(res);
        return res;
    }
}