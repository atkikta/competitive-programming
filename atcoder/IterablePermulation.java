public static class IterablePermutation implements Iterable<int[]>, Iterator<int[]>
{
    int[] a;
    boolean first = true;

    public IterablePermutation(int n) {
        assert n >= 1;
        a = new int[n];
        for(int i = 0;i < n;i++)a[i] = i;
    }

    public IterablePermutation(int... a) {
        this.a = Arrays.copyOf(a, a.length);
    }

    @Override
    public boolean hasNext() {
        if(first)return true;
        int n = a.length;
        int i;
        for(i = n - 2;i >= 0 && a[i] >= a[i+1];i--);
        return i != -1;
    }

    @Override
    public int[] next() {
        if(first) {
            first = false;
            return a;
        }
        int n = a.length;
        int i;
        for(i = n - 2;i >= 0 && a[i] >= a[i+1];i--);
        assert i != -1;
        int j;
        for(j = i + 1;j < n && a[i] < a[j];j++);
        int d = a[i]; a[i] = a[j - 1]; a[j - 1] = d;
        for(int p = i + 1, q = n - 1;p < q;p++,q--){
            d = a[p]; a[p] = a[q]; a[q] = d;
        }
        return a;
    }

    @Override
    public Iterator<int[]> iterator() {
        return this;
    }
}
