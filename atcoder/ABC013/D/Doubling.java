class Doubling {
    int[][] next;
    int size;
    int LOG_D;

    Doubling(int size, int max_step, int[] after_first){
        this.size = size;
        this.LOG_D = 0;
        int d2 = 1;
        while(d2<max_step){
            d2*=2;
            this.LOG_D++;
        }
        this.next = new int[LOG_D+1][size];
        for (int i = 0; i < size; i++) {
            this.next[0][i] = after_first[i];
        }
        init();
    }
    void init(){
        for (int k = 0; k < LOG_D; k++) {
            for (int i = 0; i < size; i++) {
                if(next[k][i]==-1){
                    next[k+1][i] = -1;
                }else{
                    next[k+1][i] = next[k][next[k][i]];
                }
            }
        }
    }
    int get_after(int pos, int step){
        assert pos<size;
        int p = pos;
        for (int i = LOG_D; i >=0; i--) {
            if(p==-1){
                break;
            }else{
                if(((step>>i)&1) == 1){
                    p = next[i][p];
                }
            }
        }
        return p;
    }    
}
