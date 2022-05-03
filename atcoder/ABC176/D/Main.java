import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
public class Main {
 
    void solve() throws IOException {
        int H= ni();
        int W= ni();
        int ch = ni()-1;
        int cw = ni()-1;
        int dh = ni()-1;
        int dw = ni()-1;
        int[][] isWall = new int[H][W];
        for (int i = 0; i < H; i++) {
            String s = ns();
            for (int j = 0; j < W; j++) {
                if(s.charAt(j) == '.') isWall[i][j] = 0;
                else isWall[i][j] = 1;
            }
        }
        UnionFind uf = new UnionFind(H*W);
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(i+1<H && isWall[i][j] == 0 && isWall[i+1][j] == 0)uf.union(i*W+j, (i+1)*W+j);
                if(j+1<W && isWall[i][j] == 0 && isWall[i][j+1] == 0)uf.union(i*W+j, i*W+j+1);
            }
        }
        ArrayList<Integer> n = uf.pars();
        ArrayList<Integer>nodes = new ArrayList<>();
        for (int i = 0; i < n.size(); i++) {
            int nn = n.get(i);
            int ii = (nn - nn%W)/W;
            int jj = nn%W;
            if(isWall[ii][jj]==0) nodes.add(n.get(i));
        }
        // System.out.println(nodes.toString());
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(Integer i:nodes){
            graph.put(i,new HashSet<>());
        }
        for (int i1 = 0; i1 < H; i1++) {
            for (int j1 = 0; j1 < W; j1++) {
                for (int i2 = i1-2; i2 <=i1+2; i2++) {
                    for (int j2 = j1-2; j2 <=j1+2; j2++) {
                        if(0<=i2 && i2<=H-1 && 0<=j2 && j2<=W-1){
                            if(isWall[i1][j1]==1||isWall[i2][j2]==1)continue;
                            int g1 = uf.find(i1*W+j1);
                            int g2 = uf.find(i2*W+j2);
                            if( g1 != g2 ){
                                graph.get(g1).add(g2);
                                graph.get(g2).add(g1);
                            }
                        }
                    }
                }
            }
        }
        // for (Integer integer : graph.keySet()) {
        //     System.out.println(integer);
        //     System.out.println(graph.get(integer).toString());
        // }
        int s = uf.find(ch*W+cw);
        int t = uf.find(dh*W+dw);
        HashMap<Integer, Integer> dis = new HashMap<>();
        for (Integer i : nodes) {
            dis.put(i, Integer.MAX_VALUE);
        }
        ArrayDeque<Integer> state = new ArrayDeque<>();
        state.addFirst(s);
        dis.put(s, 0);
        while(state.size()>0){
            int current = state.poll();
            int dist = dis.get(current);
            for (Integer next : graph.get(current)) {
                if(dis.get(next)>dist+1){
                    state.addLast(next);
                    dis.put(next, dist+1);
                }
            }
        }
        if(dis.get(t) == Integer.MAX_VALUE){
            out.println(-1);
        }else{
            out.println(dis.get(t));
        }
    }
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
        ArrayList<Integer> pars(){
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < par.length; i++) {
                if(par[i]<0) res.add(i);
            }
            return res;
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
    final int mod = 1000000007;
    final BigInteger MOD = BigInteger.valueOf(mod);
    int upperBound(ArrayList<Long> list, Long target){
        int i = Collections.binarySearch(list, target, new UpperBoundComparator<Long>());
        return ~i;
    }
    class UpperBoundComparator<T extends Comparable<? super T>> implements Comparator<T>{
        public int compare(T x, T y){
            return (x.compareTo(y) > 0) ? 1 : -1;
        }
    }
    int lowerBound(ArrayList<Long> list, Long target){
        int i = Collections.binarySearch(list, target, new LowerBoundComparator<Long>());
        return ~i;
    }
    class LowerBoundComparator<T extends Comparable<? super T>> implements Comparator<T>{
        public int compare(T x, T y){
            return (x.compareTo(y) >= 0) ? 1 : -1;
        }
    }
    int mul(int x, int y){
        int val = (int)((x * 1L * y) % mod);
        return val>=0 ? val : val+mod;
    }
    int add(int x, int y) {
        x += y;
        if(x < 0) x += mod;
        if(x>=mod) x -= mod;
        return x;
    }
    int sub(int x, int y){
        x = add(x,mod-y);
        if(x < 0) x += mod;
        if(x>=mod) x -= mod;
        return x;
    }
    String ns() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine(), " ");
        }
        return tok.nextToken();
    }
 
    int ni() throws IOException {
        return Integer.parseInt(ns());
    }
 
    long nl() throws IOException {
        return Long.parseLong(ns());
    }
 
    double nd() throws IOException {
        return Double.parseDouble(ns());
    }
 
    String[] nsa(int n) throws IOException {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = ns();
        }
        return res;
    }
 
    int[] nia(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ni();
        }
        return res;
    }
 
    long[] nla(int n) throws IOException {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = nl();
        }
        return res;
    }
 
    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
 
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        tok = new StringTokenizer("");
        Main main = new Main();
        main.solve();
        out.close();
    }
}
