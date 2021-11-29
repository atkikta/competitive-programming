#include <bits/stdc++.h>
#include <atcoder/dsu>
using namespace std;
using namespace atcoder;

int main(){
    int n,m;
    cin >> n >> m;
    dsu uf(n);
    for (int i = 0; i < m; i++)
    {
        int a,b;
        cin >> a >> b;
        uf.merge(a-1, b-1);
    }
    int size = 0;
    for(int i=0; i<n; i++){
        size = max(size, uf.size(i));
    }
    cout << size<< endl;
}