import java.util.ArrayDeque;

public class GridGraph {
    int[][] grid;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int H;
    int W;
    public GridGraph(int[][] a){
        this.grid = a;
        this.H = a.length;
        this.W = a[0].length;
    }
    public int countComponents(){
        int[][] seen = new int[H][W];
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(grid[i][j] == 1 && seen[i][j] == 0){
                    count++;
                    dfs(i, j, seen);
                }
            }
        }
        return count;
    }
    public int[][] visitAllFrom(int h, int w){
        int[][] seen = new int[H][W];
        dfs(h, w, seen);
        return seen;
    }
    public int[][] distanceFrom(int sh, int sw){
        int[][] distance = new int[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        ArrayDeque<Integer> que = new ArrayDeque<>();
        distance[sh][sw] = 0;
        que.addLast(sh);
        que.addLast(sw);
        while(que.size()>0){
            int h = que.pollFirst();
            int w = que.pollFirst();
            for (int dir = 0; dir < 4; dir++) {
                int nh = h + dx[dir];
                int nw = w + dy[dir];
                if(nh < 0 || nw < 0 || nh >= H || nw >= W) continue;
                if(grid[nh][nw] == 0) continue;
                if(distance[nh][nw] <= distance[h][w] + 1) continue;
                distance[nh][nw] = distance[h][w] + 1;
                que.addLast(nh);
                que.addLast(nw);
            }
        }
        return distance;
    }
    private void dfs(int h, int w, int[][] seen){
        seen[h][w] = 1;
        for (int dir = 0; dir < 4; dir++) {
            int nh = h + dx[dir];
            int nw = w + dy[dir];
            if(nh < 0 || nw < 0 || nh >= H || nw >= W) continue;
            if(grid[nh][nw] == 0) continue;
            if(seen[nh][nw] == 1) continue;
            dfs(nh, nw, seen);
        }
    }
}