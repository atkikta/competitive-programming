public class Inchworm {
    int[] a;
    int right = 1;
    public Inchworm(int[] a){
        this.a = a;
    }
    public long walk(){
        long res = 0;
        for (int left = 0; left < a.length; left++) {
            /* check if some condition is satisfied when right steps forward*/
            while(right < a.length && (left==right || a[right-1] < a[right])){
                /* actually step forward */
                right++;
            }
            /* do something when right is largest that statisfies the condition*/
            res += right - left;

            /* do something before step left forward */
            if (right == left) {
                ++right;
            }
            // ex. else res --;
        }
        return res;
    }
}