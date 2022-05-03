class UnionFind{
    int[] par;
    UnionFind(int n){
        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = -1;
        }
    }
    int find (int n){
        if(par[n] < 0){
            return n;
        }else{
            return find(par[n]);
        }
    }
    boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        if(par[a] > par[b]){
            int temp = b;
            b = a;
            a = temp;
        }
        par[a] += par[b];
        par[b] = a;
        return true;
    }
    int par(int n){
        return par[n];
    }
    int size(int n){
        return -par[find(n)];
    }
    boolean same(int a, int b){
        return find(a) == find(b);
    }
}