#include <bits/stdc++.h>
using namespace std;

int main(){
    long long n;
    cin >> n;
    long long ans = 0;
    for(int i=1; i*1LL*i<=n; i++){
        long long counter = n / i;
        if(counter == i){
            ans += i;
        }else{
            long long up = n / i;
            long long dw = n / (i+1) + 1;
            ans += i * (up - dw + 1);
            ans += counter;
        }
    }
    cout << ans << endl;
}