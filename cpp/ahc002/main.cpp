#include <bits/stdc++.h>
#include <sys/time.h>
using namespace std;

typedef pair<int, int> P;

const int dy[4] = {-1, 1, 0, 0};
const int dx[4] = {0, 0, -1, 1};
const char command[4] = {'U', 'D', 'L', 'R'};

const int L = 50;
int si, sj;
int t[L][L];
int p[L][L];

bool used[L][L];
bool single[L][L];
P opp[L][L];

int best=0;
string ans = "";
long reach_count = 0;
bool timeout = false;

bool in(int y, int x){
    if(0<=y && y<L && 0<=x && x<L){
        return true;
    }else{
        return false;
    }
}
struct node{
    int y, x;
    int prev_dir = -1;
    int score = 0;
};
string c_cmd = "";

void reach(const node n){
    reach_count++;
    if(reach_count>10000000) timeout = true;
    if(n.prev_dir >= 0) c_cmd += command[n.prev_dir];
    used[n.y][n.x] = true;
    if(!single[n.y][n.x]){
        P oppn = opp[n.y][n.x];
        used[oppn.first][oppn.second] = true;
    }
    if(n.score > best){
        best = n.score;
        ans = c_cmd;
    }
}
void unreach(const node n){
    if(c_cmd.size()>0) c_cmd.pop_back();
    used[n.y][n.x] = false;
    if(!single[n.y][n.x]){
        P oppn = opp[n.y][n.x];
        used[oppn.first][oppn.second] = false;        
    }
}
void dfs(const node n){
    if(timeout) return;

    reach(n);
    for (int i=0; i<4; i++) {
        int ny = n.y+dy[i];
        int nx = n.x+dx[i];
        if(!in(ny, nx) || used[ny][nx]) continue;
        node nn;
        nn.y = ny;
        nn.x = nx;
        nn.prev_dir = i;
        nn.score = n.score + p[nn.y][nn.x];
        dfs(nn);
    }
    unreach(n);
}

int main(){
    cin >> si >> sj ;
    for (size_t i = 0; i < L; i++){
        for (size_t j = 0; j < L; j++){
            cin >> t[i][j];
        }        
    }
    for (size_t i = 0; i < L; i++){
        for (size_t j = 0; j < L; j++){
            cin >> p[i][j];
        }        
    }

    for (size_t i = 0; i < L; i++){
        for(int j=0; j<L; j++){
            single[i][j] = true;
            for (int k=0; k<4; k++) {
                int y = i+dy[k];
                int x = j+dx[k];
                if(in(y, x) && t[y][x] == t[i][j]){
                    single[i][j] = false;
                    opp[i][j] = make_pair(y, x);
                    break;
                }
            }
        }
    }
    struct timeval t1, t2;
    gettimeofday(&t1, NULL);
    node start;
    start.y=si;
    start.x=sj;
    start.prev_dir = -1;
    start.score = 0;
    dfs(start);
    gettimeofday(&t2, NULL);
    cout << ans << endl;
    // cout << (t2.tv_sec-t1.tv_sec)*1000 + (t2.tv_usec-t1.tv_usec)/1000.0   << endl;
}