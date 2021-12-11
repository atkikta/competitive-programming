#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin >> n;
    if(n<=9){
        cout << "AGC00" << n << endl;
    }
    else if(n<=41){
        cout << "AGC0" << n << endl;
    }else{
        cout << "AGC0" << n+1 << endl;
    }
}