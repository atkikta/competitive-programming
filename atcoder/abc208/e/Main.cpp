#include <bits/stdc++.h>
using namespace std;

int main(){
    string n;
    int k;
    cin >> n;
    cin >> k;
    // vector<vector<vector<map<int, long long>>>> count(n.length()+1, vector<vector<map<int, long long>>>(2, vector<map<int, long long>>(2)));
    map<int, long long> count[20][2][2];
    count[0][0][1][1] = 1;
    for(int i=0; i<n.length(); i++){
        int digit = int(n.at(i) - '0');
        for(int isless=0; isless<=1; isless++){
            for(int trazero=0; trazero<=1; trazero++){
                auto mp = count[i][isless][trazero];
                for(auto p=mp.begin(); p!=mp.end(); p++){
                    for(int d=0; d<=9; d++){
                        if(isless==0 && d > digit) continue;
                        int trazero2 = trazero;
                        if(0<d)trazero2 = 0;
                        int isless2 = isless;
                        if(d < digit) isless2 = 1;
                        int val = p->first;
                        if(trazero2==0){
                            if(k < val * 1LL * d) val = numeric_limits<int>::max();
                            else val = val * d;
                            count[i+1][isless2][trazero2][val] += p->second;
                        }else{
                            count[i+1][isless2][trazero2][1] = 1;
                        }
                    }
                }
            }
        }
    }
    long long ans = 0;
    for(const auto &item: count[n.length()][0][0]){
        if(item.first <= k) ans += item.second;
    }
    for(const auto &item: count[n.length()][1][0]){
        if(item.first <= k) ans += item.second;
    }
    cout << ans << endl;
}