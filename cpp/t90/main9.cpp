#include <bits/stdc++.h>
using namespace std;

double argument(double x, double y){
    double arg = std::atan2(y, x) * 180 / M_PI;
    if(arg < 0) arg = arg + 360;
    return arg;
}
double getangle(double a, double b){
    double angle = std::abs(a-b);
    if(angle >= 180) return 360 - angle;
    return angle;
}

int main(){
    int n;
    cin >> n;
    vector<int> x;
    vector<int> y;
    for(int i=0; i<n; i++){
        int xi,yi;
        cin >> xi>> yi;
        x.push_back(xi);
        y.push_back(yi);
    }
    double ans = 0;
    for(int b=0; b<n; b++){
        int xb = x[b];
        int yb = y[b];
        vector<double> arg;
        for(int i=0; i<n; i++){
            if(i==b) continue;
            arg.push_back(argument(x[i] - xb, y[i] - yb));
        }
        sort(arg.begin(), arg.end());
        // for (auto &&i : arg){
        //     cout << i << " " ;
        // }
        // cout << endl;
        
        for(int a=0; a<arg.size(); a++){
            double target = arg[a] + 180;
            if(target >= 360) target -= 360;
            int pos = lower_bound(arg.begin(), arg.end(), target) - arg.begin();
            int pos1 = pos % arg.size();
            int pos2 = (pos + arg.size() - 1) % arg.size();
            ans = max(ans, getangle(arg[a], arg[pos1]));
            ans = max(ans, getangle(arg[a], arg[pos2]));
        }
    }
    printf("%.12lf\n", ans);
}