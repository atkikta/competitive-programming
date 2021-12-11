#include <bits/stdc++.h>
using namespace std;

int main(){
    int n, m;
    cin >> n >> m;
    map<int, vector<int>> ytox; 
    for(int i=0; i<m; i++){
        int x, y;
        cin >> x >> y;
        ytox[y].push_back(x);
    }
    for(auto p: ytox){
        sort(p.second.begin(), p.second.end());
    }
    queue<int> que;
    que.push(0);
    que.push(n);
    int ans=0;
    while(!que.empty()){
        int x = que.front();
        que.pop();
        int y = que.front();
        que.pop();
        if(x==2*n){
            ans++;
            continue;
        }
        if(ytox.count(y)){
            
        }
        auto nextblkitr = lower_bound(ytox[y].begin(), ytox[y].end(), x);
        cout << x << " " << y << " " << *nextblkitr << endl;
        if(nextblkitr == ytox[y].end()){
            que.push(2*n);
            que.push(y);
        }else{
            que.push(x);
            que.push(*nextblkitr-1);
            if(ytox.count(y-1)){
                for (int xlow : ytox[y-1]){
                    if(x < xlow && xlow < *nextblkitr){
                        que.push(xlow);
                        que.push(y-1);
                    }
                }
            }
            if(ytox.count(y+1)){
                for (int xup : ytox[y+1]){
                    if(x < xup && xup < *nextblkitr){
                        que.push(xup);
                        que.push(y+1);
                    }
                }
            }
        }
    }
    cout << ans << endl;
}